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
@Table(name="group_table")
public class Group {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int groupId;
	@Column(name="group_name")
private String groupname;

	@OneToMany(mappedBy="group")
	@JsonIgnore
	private List<GroupUser> groupUser;

	public Group()
	{
		
	}


	


	public Group(int groupId, String groupname, List<GroupUser> groupUser) {
		super();
		this.groupId = groupId;
		this.groupname = groupname;
		this.groupUser = groupUser;
	}





	public int getGroupId() {
		return groupId;
	}


	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public String getGroupname() {
		return groupname;
	}


	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}





	public List<GroupUser> getGroupUser() {
		return groupUser;
	}





	public void setGroupUser(List<GroupUser> groupUser) {
		this.groupUser = groupUser;
	}



}









	




	


	

