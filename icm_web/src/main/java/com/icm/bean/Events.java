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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="events")
public class Events implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="event_id")
	private int eventId;
	
	
	@Column(name="event_description")
	private String eventDescription;
	
	@Column(name="event_title")
	private String eventTitle;
	
	@Column(name="news_description")
	private String newsDescription;
	
	
	
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

	
	@OneToMany(mappedBy="events",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<EventsUsers> eventUsers=new HashSet<EventsUsers>();

}
