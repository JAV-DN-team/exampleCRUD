package com.framgia.springexample.service;

import com.framgia.springexample.form.EmployeeForm;
import com.framgia.springexample.form.EmployeeListForm;
import com.framgia.springexample.model.entity.Employee;

public interface EmployeeService {

	public Employee createOrUpdate(EmployeeForm employeeForm);
	
	public void deleteById(int employeeId);
	
	public EmployeeListForm findAll(EmployeeListForm employeeForm);
}
