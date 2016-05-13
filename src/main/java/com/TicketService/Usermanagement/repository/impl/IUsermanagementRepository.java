package com.TicketService.Usermanagement.repository.impl;

import java.util.Set;

import com.TicketService.model.Customer;


@SuppressWarnings("rawtypes")
public interface IUsermanagementRepository extends IBaseRepository{
	
	public Set<Customer> getAll();
	
	public Set<Customer> searchByName(String key);
	
	public Set<Customer> searchByEmail(String key);
	
	public Customer patchMovie(int id, String title, String description);
}
