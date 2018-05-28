package com.framgia.springexample.form;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sysuser database table.
 * 
 */
public class HomeLoginForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=45)
	private String password;

	@Column(nullable=false, length=45)
	private String username;

	public HomeLoginForm() {
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

}