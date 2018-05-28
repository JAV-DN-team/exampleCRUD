package com.framgia.springexample.dao.basedao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.framgia.springexample.dao.AbstractHibernateDao;
import com.framgia.springexample.model.entity.Employee;

@Transactional
public abstract class AbstractHibernateDaoImpl<T> implements AbstractHibernateDao<T> {

//	private static final Logger logger = LoggerFactory.getLogger(AbstractHibernateDaoImpl.class);

	public Class<T> clazz;

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public AbstractHibernateDaoImpl() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public T findOne(int id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public T saveOrUpdate(T entity) {
		getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	public void delete(T entity) {
		// try {
		// getCurrentSession().delete(entity.getClass().toString(), entity);
		// } catch (Exception e) {
		// logger.error(e.getMessage());
		// }
		// logger.info("nothing wrong");
		Employee employee = (Employee) entity;
		getCurrentSession().createSQLQuery("delete from " + entity.getClass().getSimpleName().toLowerCase() + " where "
				+ entity.getClass().getSimpleName().toLowerCase() + "_id=" + employee.getEmployeeId())
		.executeUpdate();
	}

	public void deleteById(int entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}

	protected final Session getCurrentSession() {
		Session session = sessionFactory.openSession();
		return session;
	}
}