package com.framgia.springexample.service.baseservice;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framgia.springexample.dao.CompanyDao;
import com.framgia.springexample.dao.EmployeeDao;
import com.framgia.springexample.form.EmployeeForm;
import com.framgia.springexample.form.EmployeeListForm;
import com.framgia.springexample.model.entity.Employee;
import com.framgia.springexample.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	CompanyDao companyDao;
	
	@Autowired
    private ModelMapper modelMapper;
	
	public Employee createOrUpdate(EmployeeForm employeeForm) {
		return employeeDao.saveOrUpdate(convertFormToEntity(employeeForm));
	}
	
	public void deleteById(int employeeId) {
		employeeDao.deleteById(employeeId);
	}
	
	public EmployeeListForm findAll(EmployeeListForm employeeForm) {
		List<Employee> employeeList = employeeDao.findAll();
//		for(Employee employee : employeeList) {
//			Company company = companyDao.findOne(employee.getCompanyId());
//			employee.setCompanyId(company.getCompanyId());
//		}
		employeeForm.setEmployeeList(employeeList);
		return employeeForm;
	}
	
	private Employee convertFormToEntity(EmployeeForm employeeForm) {
		Employee employee = modelMapper.map(employeeForm, Employee.class);
	    return employee;
	}
	
	private EmployeeListForm convertEntityToForm(Employee employee) {
		EmployeeListForm employeeForm = modelMapper.map(employee, EmployeeListForm.class);
	    return employeeForm;
	}
	
}
