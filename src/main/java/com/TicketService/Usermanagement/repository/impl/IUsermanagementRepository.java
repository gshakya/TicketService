package com.TicketService.Usermanagement.repository.impl;

import java.util.Set;

import com.TicketService.model.Customer;


public interface IUsermanagementRepository extends IBaseRepository<Customer>{
	
	public Set<Customer> getAll();
	
	public Set<Customer> searchByName(String key);
	
	public Set<Customer> searchByEmail(String key);
	
}
