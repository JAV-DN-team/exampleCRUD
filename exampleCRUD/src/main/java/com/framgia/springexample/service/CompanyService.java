package com.framgia.springexample.service;

import java.util.List;

import com.framgia.springexample.form.CompanyForm;
import com.framgia.springexample.model.entity.Company;

public interface CompanyService {
	public Company createOrUpdate(CompanyForm companyForm);

	public void delete(CompanyForm companyForm);

	public List<Company> findAll();
}
