package com.TicketService.Usermanagement.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.TicketService.Usermanagement.repository.impl.IBaseRepository;

public class BaseRepository<T> implements IBaseRepository<T>{

protected SessionFactory sessionFactory;
	
	{
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseRepository() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public T add(T t) {			
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(t);
		return t;
	}

	public T update(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
		return t;
	}

	public boolean delete(int id) {
		sessionFactory.getCurrentSession().delete(this.load(id));
		return true;
	}

	@SuppressWarnings("unchecked")
	public T get(int id) {
		sessionFactory.getCurrentSession().beginTransaction();
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}

	@SuppressWarnings("unchecked")
	public T load(int id) {
		sessionFactory.getCurrentSession().beginTransaction();
		return (T) sessionFactory.getCurrentSession().load(type, id);
	}

}
