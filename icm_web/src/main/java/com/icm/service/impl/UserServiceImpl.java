package com.icm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.icm.bean.Users;
import com.icm.model.requestDTO.UserDTO;
import com.icm.model.responseDTO.Response;
import com.icm.repository.UserRepository;
import com.icm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	JavaMailSender mailSender;
	
	BCryptPasswordEncoder bCryptPasswordEncoder;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//Need to write service
	@Override
	public Response registerUser(UserDTO user, Authentication authentication) {
		// TODO Auto-generated method stub
		logger.info(user.getEmail()+"**888888888");
		Users newUser=new Users();
		newUser.setEmailid(user.getEmail());
		bCryptPasswordEncoder=new BCryptPasswordEncoder();
		newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(newUser);
		return null;
		
	}
	
	//providing details for user registration form

}