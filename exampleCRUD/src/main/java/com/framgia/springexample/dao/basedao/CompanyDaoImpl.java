package com.framgia.springexample.dao.basedao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.framgia.springexample.dao.CompanyDao;
import com.framgia.springexample.model.entity.Company;

@Repository
@Transactional
public class CompanyDaoImpl extends AbstractHibernateDaoImpl<Company> implements CompanyDao{

}