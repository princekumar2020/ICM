package com.icm.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.icm.bean.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

	@Query(nativeQuery=true,value="select m.menu_id,m.menu_title_en,sm.sub_menu_id,sm.sub_menu_title_en  from menu m full JOIN sub_menu sm  on m.menu_id=sm.menu_id")
	List<Map> getAllMenu();

	@Query(nativeQuery=true,value="select m.menu_id,m.menu_title_en,sm.sub_menu_id,sm.sub_menu_title_en  from menu m left JOIN sub_menu sm  on m.menu_id=sm.menu_id where  m.menu_id=:id")
	List<Map> findMenuById(@org.springframework.data.repository.query.Param ("id")int id);

	
	@Query("select menuTitleEn,menuTitleHi from Menu where   menuTitleHi=:menuHi or menuTitleEn=:menuEn ")
	List findMenuByTitle(@Param("menuEn")String menuEn,@Param("menuHi")String menuHi);
	
	
}
