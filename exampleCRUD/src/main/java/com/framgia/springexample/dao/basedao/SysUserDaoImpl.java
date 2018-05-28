package com.framgia.springexample.dao.basedao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.framgia.springexample.dao.SysUserDao;
import com.framgia.springexample.model.entity.SysUser;

@Repository
@Transactional
public class SysUserDaoImpl extends AbstractHibernateDaoImpl<SysUser> implements SysUserDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public SysUser selectbyUsername(String username) {
		Session session = sessionFactory.openSession();
		String SQL_QUERY = "select * from sys_user where username=? and enable=1";
		Query query = session.createSQLQuery(SQL_QUERY).addEntity(SysUser.class);
		query.setParameter(0, username);
		SysUser sysUser = (SysUser)query.uniqueResult();

		session.close();
		return sysUser;
	}

}
