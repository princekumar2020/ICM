package com.icm.security;

/*
 * This class is made to verify that the user is 
 * valid or not by finding the user details from repository
 * and passing it to the spring security.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.icm.bean.Users;
import com.icm.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException("Error in UserDetailService in loadUserByUsername method..."+username);
		return new UserPrincipal(user, new ArrayList<>());
	}
	
	@Transactional
	public List<SimpleGrantedAuthority> findUserById(int integer){

		Users user=userRepository.getOne(integer);
		List<SimpleGrantedAuthority> authoritties=Collections.emptyList();
		if(user==null){
			throw new NullPointerException("Error in UserDetailService in findUserById method... "+ "(generated explicitely).");
		}
		return authoritties;

	}
	
	@Transactional
	public List<SimpleGrantedAuthority> findByUsername(String username){

		Users user=userRepository.findByEmail(username);
		List<SimpleGrantedAuthority> authoritties=Collections.emptyList();
		if(user==null){
			System.err.println("Invalid user!!");
			//throw new NullPointerException("Error in UserDetailService in findByUsername method... "+ "(generated explicitely).");
		List<SimpleGrantedAuthority> list =new ArrayList<SimpleGrantedAuthority>();
		list.iterator().hasNext();
		if(list.equals(null))
		{
			System.out.println("entered");
			return list;
		}
		
		}
		return authoritties;

	}
}