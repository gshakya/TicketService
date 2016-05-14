package com.TicketService.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.TicketService.model.Customer;

@Transactional
@Repository

public class CustomerDAO extends BaseDAO<Customer> implements ICustomerDAO {
	@Autowired
	SessionFactory sf;
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		sf.getCurrentSession().persist(customer); 
		
	}
	@Override
	public boolean removeCustomer(int id) {
		// TODO Auto-generated method stub
		Customer  c= (Customer) sf.getCurrentSession().get(Customer.class, id);
		sf.getCurrentSession().delete(c);
		return false;
	}
	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer  c= (Customer) sf.getCurrentSession().get(Customer.class, customer.getId());
		sf.getCurrentSession().update(c);
	
	}
	@Override
	public List<Customer> findCustomerByName(String key) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer c where c.name like :name ");
		query.setString("name", "%" + key + "%");
		List<Customer> listCustomer = query.list();
		return listCustomer;
	}
	@Override
	public List<Customer> findCustomerByEmail(String key) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer c where c.email like :email ");
		query.setString("email", "%" + key + "%");
		List<Customer> listCustomer = query.list();
		return listCustomer;
	}
	/*
	
	@Override
	public List<Customer> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer");
		query.list();
		List<Customer> listCustomer = query.list();
		return listCustomer;
	}
	@Override
	public List<Customer> searchByName(String key){
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer c where c.name like :name ");
		query.setString("name", "%" + key + "%");
		List<Customer> listCustomer = query.list();
		return listCustomer;
	}
	@Override
	public List<Customer> searchByEmail(String key){
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer c where c.email like :email ");
		query.setString("email", "%" + key + "%");
		List<Customer> listCustomer = query.list();
		return listCustomer;
	}*/
}
