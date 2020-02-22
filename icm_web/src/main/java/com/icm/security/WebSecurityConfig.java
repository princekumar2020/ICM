package com.icm.security;

/*
 * This class is made for providing access to the request that
 * which request is allowed and which is denied by using
 * antMatcher pattern.
 * 
 * If the request is allowed then it send this to authenticate.
 * 
 * It also provide beans to encrypt password and authenticate user.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.icm.configuration.JwtConfiguration;
import com.icm.repository.UserRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

	@Autowired
	JwtConfiguration jwtConfiguration;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserDetailService userDetailService;

	@Autowired
	UserRepository userRepository;


	protected void configure(HttpSecurity http) throws Exception {
		http
		.antMatcher("/**")
		.csrf().disable()
		.authorizeRequests().antMatchers("/api/user/userRegistration","/api/user/registerUser","/api/user/sendEmailOTP","/files/download/**",
				"/api/user/sendMobileOTP","/api/user/verifyOTP","/api/user/resetPassword").permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilterBefore(authenticationFilter(),UsernamePasswordAuthenticationFilter.class)
		.addFilter(new JwtUserProfileAuthorizationFilter(jwtConfiguration,userRepository,userDetailService))
		// Disable session creation on Spring Security.
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	protected JwtUserProfileAuthenticationFilter authenticationFilter() throws Exception {
		JwtUserProfileAuthenticationFilter authenticationFilter = new JwtUserProfileAuthenticationFilter(authenticationManager(), jwtConfiguration,userRepository,userDetailService);
		if(authenticationFilter != null)
			authenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/admin/login","POST"));
		logger.info("Security check...");
		return authenticationFilter;
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("Password =================== "+passwordEncoder.encode("123456"));
		//authenticate user by providing user details with encoded password.
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoderImpl();
	}
	
	

}