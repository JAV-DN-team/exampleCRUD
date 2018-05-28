package com.framgia.springexample.dao.basedao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.framgia.springexample.dao.RoleDao;
import com.framgia.springexample.model.entity.Role;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Role> selectByUsername(String username) {
		Session session = sessionFactory.openSession();
		String SQL_QUERY ="SELECT r.* FROM role r INNER JOIN user_role ur ON r.role_id=ur.role_id "
				+ "INNER JOIN sys_user su ON ur.username=su.username where su.username=?";
		Query query = session.createSQLQuery(SQL_QUERY).addEntity(Role.class);
		query.setParameter(0, username);
		List<Role> roles = (List<Role>)query.list();

		session.close();
		return roles;
	}
	
}
