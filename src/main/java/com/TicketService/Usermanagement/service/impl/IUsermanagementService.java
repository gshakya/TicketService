package com.TicketService.Usermanagement.service.impl;

import java.util.Set;

import com.TicketService.model.Customer;
import com.TicketService.model.Ticket;

public interface IUsermanagementService {
	public Customer addMovie(Customer customer);

	public Set<Ticket> getAllTickets();

	public Customer getCustomer(int id);

	public Customer updateCustomer(Customer customer);

	public boolean deleteCustomer(int id);

}
