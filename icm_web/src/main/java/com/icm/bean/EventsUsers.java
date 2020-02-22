package com.icm.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="events_users")
public class EventsUsers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userID;
	
	@Column(name="name",length=128)
	private String name;
	@Column(name="email",length=128)
	private String email;
	@Column(name="contact_no",length=10)
	private int contactNo;
	
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
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private Events events;
	

}
