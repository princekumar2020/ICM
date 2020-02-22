package com.icm.controller;

/*This is the controller class for user services.

 * Which defines all the operations related to user.
 * It includes methods like register, update, forgotPassword etc.
 * Logger is defined in this class to generate log files,
 * for checking user activities.
 *  Validations are also applied on user's fields
 * */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icm.model.requestDTO.UserDTO;
import com.icm.model.responseDTO.Response;
import com.icm.service.UserService;


@RestController
@RequestMapping("api/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	@PostMapping("/registerUser")
	public Response registerUser(@RequestBody UserDTO user, Authentication authentication){
		logger.info("registerUser api hitted...");
		
		if(user.getFirstName()==null || user.getFirstName().trim().equalsIgnoreCase("") || user.getFirstName().isEmpty())
			return new Response(Response.FAILED, null, "FirstName cannot be empty !!");

		else if(!user.getFirstName().trim().matches("^[a-zA-Z_\\ ]{3,15}$"))
			return new Response(Response.FAILED, null, "Incorrect First Name format !!");

		if(user.getLastName()==null || user.getLastName().trim().equalsIgnoreCase("") || user.getLastName().isEmpty())
			return new Response(Response.FAILED, null, "LastName cannot be empty !!");

		else if(!user.getLastName().trim().matches("^[a-zA-Z_\\ ]{3,15}$"))
			return new Response(Response.FAILED, null, "Incorrect Last Name format !!");


		if(user.getGender()==null || user.getGender().trim().equalsIgnoreCase("") || user.getGender().isEmpty())
			return new Response(Response.FAILED, null, "Gender cannot be empty !!");
		
		
		if(user.getMobileNumber()==null || user.getMobileNumber().trim().equalsIgnoreCase("") || user.getMobileNumber().isEmpty())
			return new Response(Response.FAILED, null, "Mobile number cannot be empty !!");
		
		else if(!user.getMobileNumber().matches("^[6-9]{1}[0-9]{9}$"))
			return new Response(Response.FAILED, null, "Incorrect Mobile Number format !!");
			
		
		if(user.getDob()==null || user.getDob().trim().equalsIgnoreCase("") || user.getDob().isEmpty())
			return new Response(Response.FAILED, null, "Date of birth cannot be empty !!");
		
		if(user.getSubjectSpecialist()==null || user.getSubjectSpecialist().trim().equalsIgnoreCase("")||user.getSubjectSpecialist().isEmpty() )
			return new Response(Response.FAILED, null, "Subject specialist cannot be empty !!");
		
		
		if(user.getEmail()==null || user.getEmail().trim().equalsIgnoreCase("")||user.getEmail().isEmpty())
			return new Response(Response.FAILED, null, "Email cannot be empty !!");

		if(!user.getEmail().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))
			return new Response(Response.FAILED, null, "Incorrect email format !!");
		
		
		if(user.getCategoryName()==null || String.valueOf(user.getCategoryName()).trim().equalsIgnoreCase("")|| String.valueOf(user.getCategoryName()).isEmpty())
			return new Response(Response.FAILED, null, "Category field cannot be empty !!");
		
		if(user.getDesignationId() < 0 || String.valueOf(user.getDesignationId()).trim().equalsIgnoreCase("")|| String.valueOf(user.getDesignationId()).isEmpty())
			return new Response(Response.FAILED, null, "Designation field cannot be empty !!");
		
		if(user.getExperienceId() < 0 || String.valueOf(user.getExperienceId()).trim().equalsIgnoreCase("")|| String.valueOf(user.getExperienceId()).isEmpty())
			return new Response(Response.FAILED, null, "Experience field cannot be empty !!");
		
		if(user.getOrganizationId() < 0 || String.valueOf(user.getOrganizationId()).trim().equalsIgnoreCase("")|| String.valueOf(user.getOrganizationId()).isEmpty())
			return new Response(Response.FAILED, null, "Organization field cannot be empty !!");
		
		return userService.registerUser(user, authentication);
	}
	


	
}
