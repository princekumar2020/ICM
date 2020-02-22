package com.icm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icm.bean.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByUserId(int profileId);
	
	@Query(value ="select * from users u where u.EMAILID=?1", nativeQuery = true)
	Users findByEmail(String username);
	
}
