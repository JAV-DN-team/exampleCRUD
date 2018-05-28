package com.framgia.springexample.dao.basedao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.framgia.springexample.dao.EmployeeDao;
import com.framgia.springexample.model.entity.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl extends AbstractHibernateDaoImpl<Employee> implements EmployeeDao{

}
