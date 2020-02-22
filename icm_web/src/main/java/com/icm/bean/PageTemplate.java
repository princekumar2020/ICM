package com.icm.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.aspectj.weaver.tools.Trace;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="page_template")
public class PageTemplate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "page_id", unique = true, nullable = false)
	private int pageId;
	
	
	@Column(name="page_title_en",unique=true,length=35)
private String pageTitleEn;
	
	@Column(name="page_title_hi",unique=true,length=35)
	private String pageTitleHi;
	
	@Column(name="page_url",length=125)
	private String pageUrl;
	
	
	
	@Column(name="template_html,length=5000")
	private String templateHTML;
	
	
	@Column(name="page_description_en")
	private String pageDescriptionEn;
	
	@Column(name="page_description_hi")
	private String pageDescriptionHi;
	
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

}
