package com.icm.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icm.bean.Menu;
import com.icm.model.responseDTO.Response;
import com.icm.service.MenuService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/menu")
@Slf4j
public class MenuController {
	public static final Logger logger=LoggerFactory.getLogger(MenuController.class);
	
	@Autowired MenuService menuService;
	
	@PostMapping("/add-menu")
	private ResponseEntity<Response> saveMenu(@RequestBody Menu menu)
	{
	
		
			logger.info("add-menu api hitted");
			logger.info("In add-menu Controller...");
			
			if(menu.getMenuTitleEn()==null && menu.getMenuTitleHi()==null || menu.getMenuTitleEn().trim().equalsIgnoreCase("")&& menu.getMenuTitleHi().trim().equalsIgnoreCase("")   || menu.getMenuTitleEn().isEmpty() && menu.getMenuTitleHi().isEmpty())	
//			{
//			else  if(menu.getMenuTitleEn()==null || menu.getMenuTitleEn().trim().equalsIgnoreCase("") || menu.getMenuTitleEn().trim().isEmpty() )
//			
//				return menuService.saveMenu(menu);
//			
//			 if(menu.getMenuTitleHi()==null || menu.getMenuTitleHi().trim().equalsIgnoreCase("") || menu.getMenuTitleHi().trim().isEmpty() )
//			
//				return menuService.saveMenu(menu);
			
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(Response.FAILED,null,"Menu Title Can't  be empty !!"));
			
//			for(int i=0;i<menu.getSubMenu().size();i++)
//			{
//				if(menu.getSubMenu().get(i).getSubMenuTitleEn()==null || menu.getSubMenu().get(i).getSubMenuTitleEn().trim().equalsIgnoreCase("") || menu.getSubMenu().get(i).getSubMenuTitleEn().isEmpty())	
//					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(Response.FAILED,null,"SubMenu Title Can't  be empty !!"));
//
//			}
	
			
			//logger.info("Out add-menu Controller...");
return menuService.saveMenu(menu);
		
			
	}
	
	@GetMapping("/nav-menu")
	public ResponseEntity<Response> getMenu()
	{
		
		logger.info("In nav-menu...");
		return menuService.getMenu();
		
	}
	
	@GetMapping("/nav-menu/{id}")
	public ResponseEntity<Response> getMenuById(@PathVariable int id)
	{
		
		logger.info("In nav-menu with id...");
		return menuService.getMenuById(id);
		
	}
	
//	@PostMapping("/add-menu")
//	public ResponseEntity<Response> saveMenu(@RequestBody MenuDto menuDto)
//	{
//		return menuService.saveMenu(menuDto);
//		
//	}
	
//	@PostMapping("/add-sub-menu")
//	public ResponseEntity<Response> saveSubMenu(@RequestBody SubMenuDto subMenuDto)
//	{
//		return menuService.saveSubMenu(subMenuDto);
//		
//	}

}
