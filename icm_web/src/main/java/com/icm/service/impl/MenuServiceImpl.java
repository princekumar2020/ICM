package com.icm.service.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.icm.bean.Menu;
import com.icm.bean.SubMenu;
import com.icm.model.responseDTO.Response;
import com.icm.repository.MenuRepository;
import com.icm.repository.SubMenuRepository;
import com.icm.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {

private static final Logger logger=LoggerFactory.getLogger(MenuServiceImpl.class);

@Autowired
private MenuRepository menuRepository;

@Autowired 
private SubMenuRepository subMenuRepository;

//@Override
//public ResponseEntity<Response> saveMenu(MenuDto menuDto) {
//	Menu menu=new Menu();
//	menu.setTitleEnglish(menuDto.getMenuEnglishTitle());
//	menu=menuRepository.save(menu);
//	return new ResponseEntity<Response>(new Response(Response.SUCCESS,menu,"Menu Saved Successfully."),HttpStatus.OK);
//}

//@Override
//public ResponseEntity<Response> saveSubMenu(SubMenuDto subMenuDto) {
//	SubMenu subMenu=new SubMenu();
//	subMenu.setTitleEnglish(subMenuDto.getSubMenuEnglishTitle());
//	subMenu=subMenuRepository.save(subMenu);
//return new ResponseEntity<Response>(new Response(Response.SUCCESS,subMenu,"Sub Menu Saved Successfully."),HttpStatus.OK);
//}

	@Override@Async
	public ResponseEntity<Response> saveMenu(Menu menu) {
		logger.info("In add-menu ServiceImpl...");
		
//		if(menu.getMenuTitleEn()==null  ||menu.getMenuTitleEn().trim().equalsIgnoreCase("") || menu.getMenuTitleEn().isEmpty())	
//			
//			if( menu.getMenuTitleHi()==null ||  menu.getMenuTitleHi().trim().equalsIgnoreCase("")||   menu.getMenuTitleHi().isEmpty())
//				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(Response.FAILED,null,"Menu Title Can't  be empty !!"));
//	
		
		Menu menuDB=null;
		List menuTitle=null;
//Menu menu=new Menu();
//menu.getMenuId();
//menu.setTitleEnglish(menuDto.getMenuTitleHindi());
//menu.setContentEnglish(menuDto.getMenuTitleEnglish());
//menu.setCreateddate(new Date());
//menu.setUpdateddate(new Date());
//menu.setCreatedBy(menuDto.getMenuCreatedBy());
//menu.setUpdatedBy(menuDto.getMenuUpdatedBy());
//menu.setStatus(menuDto.getMenuStatus());
//menu.setPublished(menuDto.getMenuPublished());
//menu.setDisplay(menuDto.getMenuDisplay());
//menu.setMarkForDelete(menuDto.getMenuMarkForDelete());
//menu.setSequence(menuDto.getMenuSequence());
//menu.setContentHindi(menuDto.getMenuContentHindi());
//menu.setContentEnglish(menuDto.getMenuContentEnglish());
		


		menuTitle=menuRepository.findMenuByTitle(menu.getMenuTitleHi(),menu.getMenuContentEn());
	
		while(menuTitle.iterator().hasNext())
		{ 
				
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new Response(Response.FAILED,null,"Menu Already Exist."));
		}
		
	

	
		
menuDB=menuRepository.save(menu);


//for(int i=0;i<menuDto.getSubMenuDto().size();i++)
//{
//	subMenu=new SubMenu();	
//	menu.getMenuId();
//	subMenu.setTitleEnglish(menuDto.getMenuTitleHindi());
//	subMenu.setContentEnglish(menuDto.getMenuTitleEnglish());
//	subMenu.setCreateddate(new Date());
//	subMenu.setUpdateddate(new Date());
//	subMenu.setCreatedBy(subMenu.getCreatedBy());
//	subMenu.setUpdatedBy(menuDto.getMenuUpdatedBy());
//	subMenu.setStatus(menuDto.getMenuStatus());
//	subMenu.setPublished(menuDto.getMenuPublished());
//	subMenu.setDisplay(menuDto.getMenuDisplay());
//	subMenu.setMarkForDelete(menuDto.getMenuMarkForDelete());
//	subMenu.setSequence(menuDto.getMenuSequence());
//	subMenu.setContentHindi(menuDto.getMenuContentHindi());
//	subMenu.setContentEnglish(menuDto.getMenuContentHindi());
//	subMenu=subMenuRepository.save(subMenu);		
//}
if(!StringUtils.isEmpty(menu.getSubMenu()))
{
for(int i=0;i<menu.getSubMenu().size();i++)
{
	menu.getSubMenu().get(i).setMenu(menuDB);
}
}
else
{
	return ResponseEntity.status(HttpStatus.OK).body(new Response(Response.SUCCESS,menuDB,"Menu Saved Successfully."));
}
List<SubMenu> subMenuDB=subMenuRepository.saveAll(menu.getSubMenu());	
		
	
//List responseData=new ArrayList();
////responseData.add(menuDB);
////responseData.add(subMenuDB);
logger.info("Out add-menu ServiceImpl...");
return ResponseEntity.status(HttpStatus.OK).body(new Response(Response.SUCCESS,subMenuDB,"Menu and Sub Menu Saved Successfully."));

}

	@Override
	public ResponseEntity<Response> getMenu() {
		
		logger.info("In Add menu SeviceImpl...");
		
		List<Map> menu=menuRepository.getAllMenu();
		logger.info("In nav menu SeviceImpl ...");

		if(menu.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(Response.SUCCESS,menu,"Menu Not Exist!"));

		}
		logger.info("out Add menu SeviceImpl...");
	return ResponseEntity.status(HttpStatus.OK).body(new Response(Response.SUCCESS,menu,"data fetched successfully."));
	}

	@Override	
	public ResponseEntity<Response> getMenuById(int id) {
		// TODO Auto-generated method stub
		logger.info("In nav menu with id SeviceImpl ...");

		List<Map> obj=menuRepository.findMenuById(id);
	
	if(obj.isEmpty())
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(Response.SUCCESS,null,"Menu Not Exist With Id!"));

	logger.info("out nav menu with id SeviceImpl ...");

		return ResponseEntity.status(HttpStatus.OK).body(new Response(Response.SUCCESS,obj,"data fetched successfully."));

	}

	
}
