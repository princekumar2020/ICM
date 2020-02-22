package com.icm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icm.bean.SubMenu;

@Repository
public interface SubMenuRepository extends JpaRepository<SubMenu, Integer>{

	
}
