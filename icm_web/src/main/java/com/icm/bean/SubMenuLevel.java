package com.icm.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="sub_menu_level")
public class SubMenuLevel implements Serializable {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_menu_level_id", unique = true, nullable = false)
	private int subMenuLevelId;
	
	@Column(name="sub_menu_level_title_hi",length=128,unique = true)
	private String subMenuLevelTitleHi;
	
	@Column(name="sub_menu_level_title_en",length=128,unique = true)
	private String subMenuLevelTitleEi;

 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createddate", nullable = false, length = 29)
	private Date createddate;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updateddate", nullable = false, length = 29)
	private Date updateddate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	
	@Column(name="field_1")
	private String field1;
	
	@Column(name="field_2")
	private String field2;
	
	@Column(name="field_3")
	private Integer field3;
	

	@Column(name="status")
	private int status;
	
	@Column(name="sub_menu_content_level_hi")
	private String subMenuContentLevelHi;
	
	@Column(name="sub_menu_content_level_en")
	private String subMenuContentLevelEn;
	
	@Column(name="published")
	private int published;
	
	@Column(name="display")
	private int display;
	
	@Column(name="markfordelete")
	private int markForDelete;
	
	@Column(name="sequence")
	private int sequence;
	

	@ManyToOne
	@JoinColumn(name = "sub_menu_id")
	private SubMenu subMenu;


	
	
	public SubMenuLevel() {
		super();
	}


	public int getSubMenuLevelId() {
		return subMenuLevelId;
	}


	public void setSubMenuLevelId(int subMenuLevelId) {
		this.subMenuLevelId = subMenuLevelId;
	}


	public String getSubMenuLevelTitleHi() {
		return subMenuLevelTitleHi;
	}


	public void setSubMenuLevelTitleHi(String subMenuLevelTitleHi) {
		this.subMenuLevelTitleHi = subMenuLevelTitleHi;
	}


	public String getSubMenuLevelTitleEi() {
		return subMenuLevelTitleEi;
	}


	public void setSubMenuLevelTitleEi(String subMenuLevelTitleEi) {
		this.subMenuLevelTitleEi = subMenuLevelTitleEi;
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


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
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


	public Integer getField3() {
		return field3;
	}


	public void setField3(Integer field3) {
		this.field3 = field3;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getSubMenuContentLevelHi() {
		return subMenuContentLevelHi;
	}


	public void setSubMenuContentLevelHi(String subMenuContentLevelHi) {
		this.subMenuContentLevelHi = subMenuContentLevelHi;
	}


	public String getSubMenuContentLevelEn() {
		return subMenuContentLevelEn;
	}


	public void setSubMenuContentLevelEn(String subMenuContentLevelEn) {
		this.subMenuContentLevelEn = subMenuContentLevelEn;
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


	public SubMenu getSubMenu() {
		return subMenu;
	}


	public void setSubMenu(SubMenu subMenu) {
		this.subMenu = subMenu;
	}

	

}	