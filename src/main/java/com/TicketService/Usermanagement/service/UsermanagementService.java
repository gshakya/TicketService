package com.TicketService.Usermanagement.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.TicketService.Usermanagement.service.impl.IUsermanagementService;
import com.TicketService.model.Customer;
import com.TicketService.model.Ticket;

@Transactional
@Service
public class UsermanagementService implements IUsermanagementService{

	@Override
	public Customer addMovie(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}



}
