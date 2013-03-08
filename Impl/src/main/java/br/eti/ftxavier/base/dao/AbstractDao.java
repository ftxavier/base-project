package br.eti.ftxavier.base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao<T, ID extends Serializable> implements Dao<T, ID> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findList(Integer maxResults, Integer offset) {
		return getCurrentSession().createCriteria(getPersistentClass())
				.setFirstResult(offset).setMaxResults(maxResults).list();
	}

	@Override
	public void save(T entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void remove(T entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(ID identifier) {
		return (T) getCurrentSession().get(getPersistentClass(), identifier);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getCurrentSession().createCriteria(getPersistentClass()).list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
}
