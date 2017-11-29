package com.jpahibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractJpaDAO<T> implements JpaDAO<T> {

    private Class<T> clazz;
    
    @Autowired
	protected SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }
    @Override
    public T findOne(final Integer id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }
    @Override
    public void create(T entity) {
        entityManager.persist(entity);
    }
    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }
    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }
    
    public Session getSession() {
    	Session session = entityManager.unwrap(Session.class);
		return session;
	}
}