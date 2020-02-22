package com.icm.service;

import org.springframework.http.ResponseEntity;

import com.icm.bean.Menu;
import com.icm.model.responseDTO.Response;

public interface MenuService {

	//ResponseEntity<Response> saveMenu(MenuDto menuDto);

	//ResponseEntity<Response> saveSubMenu(SubMenuDto subMenuDto);

	ResponseEntity<Response> saveMenu(Menu menu);

	

	ResponseEntity<Response> getMenu();



	ResponseEntity<Response> getMenuById(int id);

}
