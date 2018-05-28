package com.framgia.springexample.dao;

import java.util.List;

public interface AbstractHibernateDao<T> {
	public T findOne(int id);

	public List<T> findAll();

	public T saveOrUpdate(T entity);

	public void delete(T entity);

	public void deleteById(int entityId);
}
