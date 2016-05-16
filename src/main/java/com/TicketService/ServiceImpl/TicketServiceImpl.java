package com.TicketService.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TicketService.Model.Ticket;
import com.TicketService.Repository.TicketRepository;
import com.TicketService.Service.TicketService;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

}
