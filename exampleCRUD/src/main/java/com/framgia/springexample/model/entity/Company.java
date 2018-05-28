package com.framgia.springexample.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name = "company")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;

	@Id
	@GeneratedValue
	@Column(name = "company_id")
	private int companyId;

	@NotEmpty
	@Column(name = "company_name")
	private String companyName;

	public Company() {
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}