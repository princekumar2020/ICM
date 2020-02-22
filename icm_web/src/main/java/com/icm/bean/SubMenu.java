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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity(name="sub_menu")
@Table(name="sub_menu",schema="public")
public class SubMenu implements Serializable {

	
				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				@Column(name = "sub_menu_id", unique = true, nullable = false)
				private int subMenuId;
					
				    
				@Column(name="sub_menu_title_hi",length=128,unique = true)
				private String subMenuTitleHi;
				
				@Column(name="sub_menu_title_en",length=128,unique = true)
				private String subMenuTitleEn;
			
			 
				@CreationTimestamp
				@Column(name = "createddate", nullable = false, length = 29)
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
				private Integer field3;
				
				@Column(name="status")
				private int status;
				
				@Column(name="sub_menu_content_hi")
				private String subMenuContentHi;
				
				@Column(name="sub_menu_content_en")
				private String subMenuContentEn;
				
				@Column(name="published")
				private int published;
				
				@Column(name="display")
				private int display;
				
				@Column(name="markfordelete")
				private int markForDelete;
				
				@Column(name="sequence")
				private int sequence;
				
				@ManyToOne
				@JoinColumn(name = "menu_id")
				 private Menu menu;
				
				
				@OneToMany(mappedBy = "subMenu", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
				private Set<SubMenuLevel> subMenu=new HashSet<SubMenuLevel>();


				
				
				public SubMenu() {
					super();
				}


				public int getSubMenuId() {
					return subMenuId;
				}


				public void setSubMenuId(int subMenuId) {
					this.subMenuId = subMenuId;
				}


				public String getSubMenuTitleHi() {
					return subMenuTitleHi;
				}


				public void setSubMenuTitleHi(String subMenuTitleHi) {
					this.subMenuTitleHi = subMenuTitleHi;
				}


				public String getSubMenuTitleEn() {
					return subMenuTitleEn;
				}


				public void setSubMenuTitleEn(String subMenuTitleEn) {
					this.subMenuTitleEn = subMenuTitleEn;
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


				public String getSubMenuContentHi() {
					return subMenuContentHi;
				}


				public void setSubMenuContentHi(String subMenuContentHi) {
					this.subMenuContentHi = subMenuContentHi;
				}


				public String getSubMenuContentEn() {
					return subMenuContentEn;
				}


				public void setSubMenuContentEn(String subMenuContentEn) {
					this.subMenuContentEn = subMenuContentEn;
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


				public Menu getMenu() {
					return menu;
				}


				public void setMenu(Menu menu) {
					this.menu = menu;
				}


				public Set<SubMenuLevel> getSubMenu() {
					return subMenu;
				}


				public void setSubMenu(Set<SubMenuLevel> subMenu) {
					this.subMenu = subMenu;
				}

				}