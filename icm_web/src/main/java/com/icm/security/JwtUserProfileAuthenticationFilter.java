package com.icm.security;

/*
 * This class is made to generate token when the user logged in.
 * And refreshes the token after every request from the browser.\
 * It generate token according to the SignatureAlgorithm.HS512.
 */

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icm.bean.Users;
import com.icm.configuration.JwtConfiguration;
import com.icm.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUserProfileAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private static final Logger logger = LoggerFactory.getLogger(JwtUserProfileAuthenticationFilter.class);
	
	//This is the nested class which provide setter and getter
	//methods for login request as username and password.
	public static class LoginProfileRequest {

		private String username;
		private String password;
		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
	}

	AuthenticationManager authenticationManager;
	JwtConfiguration jwtConfiguration;
	UserRepository userRepository;	
	UserDetailService userDetailService;

	public JwtUserProfileAuthenticationFilter(AuthenticationManager authenticationManager,
			JwtConfiguration jwtConfiguration,UserRepository userRepository,UserDetailService userDetailService) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtConfiguration = jwtConfiguration;
		this.userRepository = userRepository;
		this.userDetailService = userDetailService;
	}

	//this method called when user tries to attempt authentication.
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
			HttpServletResponse res) throws AuthenticationException {
		try {
			LoginProfileRequest loginRequest = new ObjectMapper()
					.readValue(req.getInputStream(), LoginProfileRequest.class);
			List<SimpleGrantedAuthority> authoritties = userDetailService.findByUsername(loginRequest.getUsername());


			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginRequest.getUsername(),
							loginRequest.getPassword(),
							authoritties)
					);
		} 
		
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	//this method called when authentication is not successful.
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
      logger.info("Authentication failed");
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.setContentType(MediaType.TEXT_PLAIN_VALUE);
      response.setCharacterEncoding("utf-8");
      response.getWriter().print(failed.getLocalizedMessage());
      response.getWriter().flush();
      
		
		logger.info("Try to login with incorrect password with ip-address: "+request.getRemoteAddr());
		
		//throw new RuntimeException(failed);
	}
	
	


	//this method called when authentication is successful.
	@Override
	protected void successfulAuthentication(HttpServletRequest req,
			HttpServletResponse res,
			FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		Users user = ((UserPrincipal) auth.getPrincipal()).getUser();
		UserSession userSession = new UserSession(user.getUserId());
		addTokenToResponse(jwtConfiguration, res, userSession,req);
		res.addHeader("name", user.getEmailid());
	//	res.addHeader("name", user.getFirstName());	//+" "+user.getLastName());
		res.addHeader("id", user.getUserId()+"");
		
		try{
	//		String role = user.getUserRoles().iterator().next().getRole().getRoleName();
	//		res.addHeader("role", role);
			
		}catch(java.util.NoSuchElementException ex){
			logger.error("Role not found for logonId: "+user.getEmailid());
			res.addHeader("role", "not found !!");
		}
		logger.info("User logged in by emailId: \""+user.getEmailid()+"\" with ip-address: "+req.getRemoteAddr());
		
/*		try{
			List<UserRole> userRoleList = userRoleRepository.findAll();
			for (UserRole userRole : userRoleList) {
				if(userRole.getUser().getUserId() == user.getUserId()){
					List<Role> roleList = roleRepository.findAll();
					for (Role role : roleList) {
						if(userRole.getId().getRoleId() == role.getRoleId())
							res.addHeader("role", role.getRoleName());
						}
					}
			}
		logger.info("user logged in by emailId: "+user.getEmail());
		
		}catch(java.lang.NullPointerException e){
			e.printStackTrace();
			logger.error("Role not found for emailId: "+user.getEmail());
			res.addHeader("role", "not found");
		}	*/
	}

	//this method is made to generate token on jwt token signature algorithm.
	//it also includes expiration time to token.
	public static void addTokenToResponse(JwtConfiguration jwtConfiguration, HttpServletResponse res, UserSession userSession, HttpServletRequest req) throws IOException {
			LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(jwtConfiguration.expirationTimeMin);
			String token = Jwts.builder()
					.setSubject(new ObjectMapper().writeValueAsString(userSession))
					.setExpiration(Date.from(expirationTime.atZone(ZoneId.systemDefault()).toInstant()))
					.signWith(SignatureAlgorithm.HS512, jwtConfiguration.secret.getBytes())
					.compact();
			res.addHeader(jwtConfiguration.headerName, token);
	//	res.getWriter().print("Token Generated Successfully");
		//res.setStatus(HttpServletResponse.SC_OK);
	}

}