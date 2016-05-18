package com.TicketService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TicketService.Model.Customer;

@Service
public interface CustomerManagementService {

	public List<Customer> findCustomerByName(String name);

	public List<Customer> findCustomerByEmail(String email);

	public List<Customer> findCustomerByNameAndEmail(String CustomerName, String CustomerEmail);

	public Customer findOne(long id);

	public void add(Customer customer);

	public void update(Customer customer);

	public void remove(long id);
}
