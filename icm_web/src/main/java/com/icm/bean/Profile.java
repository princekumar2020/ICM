package com.icm.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="profile")
public class Profile implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="profile_id",nullable=false,unique=true)
	private int ProfileId;
	
	@Column(name="first_name",length=128)
	private String firstName;
	@Column(name="middle_name",length=128)
	private String middleName;
	@Column(name="last_name",length=128)
	private String lastName;
	@Column(name="designation")
	private String designation;
	@Column(name="fb_hyperlink")
	private String fbHyperLink;
	@Column(name="twitter_hyperlink")
	private String twitterHyperLink;
	@Column(name="profile_zone")
	private String profileZone;
	@Column(name="profile_description")
	private String profileDescription;
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
	
	@Column(name="published")
	private int published;
	
	@Column(name="display")
	private int display;
	
	@Column(name="markfordelete")
	private int markForDelete;
	
	@Column(name="sequence")
	private int sequence;

}
