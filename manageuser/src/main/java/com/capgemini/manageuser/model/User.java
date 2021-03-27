package com.capgemini.manageuser.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_table")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int userid;
	@Column(name="user_name")
private String username;
	@Column(name="password")
private String password;
	@Column(name="country")
	private String country;
	@Column(name="pincode")
	private int pincode;
	@Column(name="role")
	private String role;
	
@OneToMany(mappedBy="user")
@JsonIgnore
private List<GroupUser> groupuser;
	
	/*
	 * @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	 * 
	 * @JoinColumn(name="group_id")
	 * 
	 * @JsonIgnore private Group group;
	 */
	public User()
	{
		
	}
	
	public User(int userid, String username, String password, String country, int pincode, String role,
			List<GroupUser> groupuser) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.country = country;
		this.pincode = pincode;
		this.role = role;
		this.groupuser = groupuser;
	}

	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<GroupUser> getGroupuser() {
		return groupuser;
	}

	public void setGroupuser(List<GroupUser> groupuser) {
		this.groupuser = groupuser;
	}







}
