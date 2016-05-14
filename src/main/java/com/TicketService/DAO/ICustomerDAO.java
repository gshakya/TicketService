package com.TicketService.DAO;

import java.util.List;
import com.TicketService.model.Customer;


public interface ICustomerDAO extends IBaseDAO<Customer>{
	
	public void addCustomer(Customer customer);	
	
	public boolean removeCustomer(int id);
	
	public void updateCustomer(Customer customer);
	
	public List<Customer> findCustomerByName(String name);
	
	public List<Customer> findCustomerByEmail(String email);
	
	
}
