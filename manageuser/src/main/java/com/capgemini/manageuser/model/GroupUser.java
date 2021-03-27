package com.capgemini.manageuser.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="group_user_table")
public class GroupUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int guid;
@ManyToOne

	private Group group;
@ManyToOne

private User user;
public GroupUser()
{
	
}
public GroupUser(Group group)
{
	this.group=group;
}
public GroupUser(User user)
{
	this.user=user;
}
public GroupUser(int guid, Group group, User user) {
	super();
	this.guid = guid;
	this.group = group;
	this.user = user;
}


public int getGuid() {
	return guid;
}


public void setGuid(int guid) {
	this.guid = guid;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}

public Group getGroup() {
	return group;
}

public void setGroup(Group group) {
	this.group = group;
}

}
