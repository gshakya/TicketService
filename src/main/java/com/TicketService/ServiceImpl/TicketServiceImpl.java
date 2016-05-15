package com.TicketService.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TicketService.Service.TicketService;
import com.TicketService.model.Ticket;
import com.TicketService.repository.TicketRepository;

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
