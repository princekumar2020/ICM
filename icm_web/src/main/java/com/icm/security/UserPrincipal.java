package com.icm.security;

/*
 * This class is made to get user in our implementation classes,
 * By setting user object after authentication.
 */

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.icm.bean.Users;

@SuppressWarnings("serial")
public class UserPrincipal extends org.springframework.security.core.userdetails.User {

	private Users user;

	public UserPrincipal(Users user,List<SimpleGrantedAuthority> authoritties) {
		super(user.getEmailid(), user.getPassword(),authoritties);//load authorities
		this.user = user;
	}
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
