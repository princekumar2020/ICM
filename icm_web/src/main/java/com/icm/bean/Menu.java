package com.icm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="menu",schema="public")
public class Menu implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id", unique = true, nullable = false)
	private int menuId;
	
	@Column(name="menu_title_hi",length=128,unique = true)
	private String menuTitleHi;
	
	@Column(name="menu_title_en",length=128,unique = true)
	private String menuTitleEn;
	
	
	
	@CreationTimestamp
	@Column(name = "createddate", nullable = false, updatable = false, length = 29)
	private Date createddate;
	
	@UpdateTimestamp
	@Column(name = "updateddate", nullable = false, length = 29)
	private Date updateddate;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	
	@Column(name="field_1")
	private String field1;
	
	@Column(name="field_2")
	private String field2;
	
	@Column(name="field_3")
	private int field3;
	

	@Column(name="status")
	private int status;
	
	
	
	@Column(name="published")
	private int published;
	
	@Column(name="display")
	private int display;
	
	@Column(name="markfordelete")
	private int markForDelete;
	
	@Column(name="sequence")
	private int sequence;
	
	@Column(name="menu_content_hi")
	private String menuContentHi;
	
	@Column(name="menu_content_en")
	private String menuContentEn;
	
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonBackReference
	private List<SubMenu> subMenu;


	public Menu() {
		super();
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuTitleHi() {
		return menuTitleHi;
	}

	public void setMenuTitleHi(String menuTitleHi) {
		this.menuTitleHi = menuTitleHi;
	}

	public String getMenuTitleEn() {
		return menuTitleEn;
	}

	public void setMenuTitleEn(String menuTitleEn) {
		this.menuTitleEn = menuTitleEn;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public int getField3() {
		return field3;
	}

	public void setField3(int field3) {
		this.field3 = field3;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public int getMarkForDelete() {
		return markForDelete;
	}

	public void setMarkForDelete(int markForDelete) {
		this.markForDelete = markForDelete;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getMenuContentHi() {
		return menuContentHi;
	}

	public void setMenuContentHi(String menuContentHi) {
		this.menuContentHi = menuContentHi;
	}

	public String getMenuContentEn() {
		return menuContentEn;
	}

	public void setMenuContentEn(String menuContentEn) {
		this.menuContentEn = menuContentEn;
	}

	public List<SubMenu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<SubMenu> subMenu) {
		this.subMenu = subMenu;
	}



	
}		