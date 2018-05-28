package com.framgia.springexample.dao.basedao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.framgia.springexample.dao.UserRoleDao;
import com.framgia.springexample.model.entity.UserRole;

@Repository
@Transactional
public class UserRoleDaoImpl implements UserRoleDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<UserRole> selectByUsername(String username) {
		Session session = sessionFactory.openSession();
		String SQL_QUERY ="select role_id from user_role where username=?";
		Query query = session.createSQLQuery(SQL_QUERY);
		query.setParameter(0, username);
		List<UserRole> userRoleList = (List<UserRole>)query.list();

		session.close();
		return userRoleList;
	}
	
}
