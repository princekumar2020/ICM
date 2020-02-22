package com.icm.security;

/*
 * This class is made for token based Authentication process.
 * It find token and matches it from it's signature,
 * if token is not found and not follow it's signature it returns null in header.
 * if the token matched then it refreshes the token and send new token in header.
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icm.bean.Users;
import com.icm.configuration.JwtConfiguration;
import com.icm.repository.UserRepository;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;

public class JwtUserProfileAuthorizationFilter extends BasicAuthenticationFilter {

	JwtConfiguration jwtConfiguration;
	
	UserRepository userRepository;
	
	UserDetailService userDetailService;
	
    public JwtUserProfileAuthorizationFilter(JwtConfiguration jwtConfiguration,UserRepository userRepository,UserDetailService userDetailService) {
    	super(new AuthenticationManager() {
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				return null;
			}
		});
        this.jwtConfiguration = jwtConfiguration;
        this.userRepository = userRepository;
        this.userDetailService = userDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(jwtConfiguration.headerName);
        HttpServletResponse resp = res;
        //if token not found, returns null.
        if (header == null) {
        	logger.error("No token found...");
        	res.addHeader(jwtConfiguration.headerName, "No Token found !!");
            chain.doFilter(req, res);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(header, resp);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        // Refreshes the JWT token.
        JwtUserProfileAuthenticationFilter.addTokenToResponse(jwtConfiguration, res, new UserSession(userPrincipal.getUser().getUserId()),req);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token, HttpServletResponse resp) throws IOException {
    	try{
	    	String subjectJson = Jwts.parser()
	    			.setSigningKey(jwtConfiguration.secret.getBytes())
	    			.parseClaimsJws(token)
	    			.getBody()
	    			.getSubject();
	    	//authenticating user.
	    	UserSession userSession = new ObjectMapper().readValue(subjectJson, UserSession.class);
	    	if (userSession != null) {
	    		Users user = userRepository.findByUserId(userSession.getProfileId());
	    		List<SimpleGrantedAuthority> authoritties=userDetailService.findUserById(userSession.getProfileId());
	    	      return new UsernamePasswordAuthenticationToken(new UserPrincipal(user,authoritties), null,authoritties);
	    	}
    	}catch(ExpiredJwtException ex){
    		resp.addHeader(jwtConfiguration.headerName, "Token expired !!");
    		throw new RuntimeException("Token expired",ex);
    	}catch(MalformedJwtException ex){
    		throw new RuntimeException("No Token",ex);
    	}
    	return null;
    }
    
}