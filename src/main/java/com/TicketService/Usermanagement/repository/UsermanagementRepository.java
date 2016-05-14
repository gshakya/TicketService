package com.TicketService.Usermanagement.repository;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.TicketService.Usermanagement.repository.impl.IUsermanagementRepository;
import com.TicketService.model.Customer;

@Transactional
@Repository

public class UsermanagementRepository extends BaseRepository<Customer> implements IUsermanagementRepository {
	@Override
	public Set<Customer> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer");
		query.list();
		Set<Customer> setCustomer = new HashSet<Customer>(query.list());
		return setCustomer;
	}
	@Override
	public Set<Customer> searchByName(String key){
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer c where c.name like :name ");
		query.setString("name", "%" + key + "%");
		Set<Customer> setCustomer = new HashSet<Customer>(query.list());
		return setCustomer;
	}
	@Override
	public Set<Customer> searchByEmail(String key){
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer c where c.email like :email ");
		query.setString("email", "%" + key + "%");
		Set<Customer> setCustomer = new HashSet<Customer>(query.list());
		return setCustomer;
	}

}
