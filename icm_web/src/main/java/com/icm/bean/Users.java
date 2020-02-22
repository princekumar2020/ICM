package com.icm.bean;
// Generated 3 Feb, 2020 5:17:24 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", schema = "public")
public class Users implements java.io.Serializable {

	private int userId;
	private String userName;
	private String password;
	private String emailid;
	private String firstName;
	private String lastName;
	private String mobileno;
	private Date createDate;
	private Date updateDate;
	private String status;
	private Integer field1;
	private String field2;
	private String field3;
	private Integer data;
	private Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>(0);

	public Users() {
	}

	public Users(int userId) {
		this.userId = userId;
	}

	public Users(int userId, String userName, String password, String emailid, String firstName, String lastName,
			String mobileno, Date createDate, Date updateDate, String status, Integer field1, String field2,
			String field3, Integer data, Set<UserAuthority> userAuthorities) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emailid = emailid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileno = mobileno;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.status = status;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.data = data;
		this.userAuthorities = userAuthorities;
	}
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "appUsers"))

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "EMAILID")
	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "MOBILENO")
	public String getMobileno() {
		return this.mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", length = 13)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE", length = 13)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "STATUS", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "FIELD1")
	public Integer getField1() {
		return this.field1;
	}

	public void setField1(Integer field1) {
		this.field1 = field1;
	}

	@Column(name = "FIELD2", length = 10)
	public String getField2() {
		return this.field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	@Column(name = "FIELD3")
	public String getField3() {
		return this.field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	@Column(name = "data")
	public Integer getData() {
		return this.data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<UserAuthority> getUserAuthorities() {
		return this.userAuthorities;
	}

	public void setUserAuthorities(Set<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}

}