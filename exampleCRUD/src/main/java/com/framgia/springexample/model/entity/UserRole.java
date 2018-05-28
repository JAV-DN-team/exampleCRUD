package com.framgia.springexample.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the user_role database table.
 * 
 */
@Entity
@Table(name="user_role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_id", nullable=false, length=45)
	private String roleId;

	@Id
	@Column(nullable=false)
	private int username;

	public UserRole() {
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public int getUsername() {
		return this.username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

}