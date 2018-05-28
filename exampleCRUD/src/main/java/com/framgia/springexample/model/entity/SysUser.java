package com.framgia.springexample.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sysuser database table.
 * 
 */
@Entity
@Table(name="sys_user")
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=45)
	private String enable;

	@Column(nullable=false, length=45)
	private String password;

	@Id
	@Column(nullable=false, length=45)
	private String username;
	
	@OneToMany(targetEntity=UserRole.class, mappedBy="username", fetch=FetchType.LAZY)
    private List<Role> roles = new ArrayList<Role>();

	public SysUser() {
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}