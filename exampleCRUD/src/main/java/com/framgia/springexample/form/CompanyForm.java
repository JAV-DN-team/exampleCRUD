package com.framgia.springexample.form;

import java.io.Serializable;

public class CompanyForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String address;

	private int companyId;

	private String companyName;

	public CompanyForm() {
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