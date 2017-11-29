package com.jpahibernate.dao;

import java.util.List;

/**
 * Created by paulo on 18/11/17.
 */
public interface  JpaDAO<T> {

	T findOne(final Integer id);
	List<T> findAll();
	void create(T entity);
	T update(T entity);
	void delete(T entity);
		
}


