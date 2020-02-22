package com.icm.service;

import org.springframework.security.core.Authentication;

import com.icm.model.requestDTO.UserDTO;
import com.icm.model.responseDTO.Response;



public interface UserService {
	
	Response registerUser(UserDTO user, Authentication authentication);


}