package com.framgia.springexample.service;

import java.util.List;

public interface AbstractService<T> {
	public T findOne(int id);

	public List<T> findAll();

	public T saveOrUpdate(T entity);

	public void delete(T entity);

	public void deleteById(int entityId);
}
