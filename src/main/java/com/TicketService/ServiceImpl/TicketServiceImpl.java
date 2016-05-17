package com.TicketService.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TicketService.Model.Ticket;
import com.TicketService.Repository.ITicketRepository;
import com.TicketService.Service.TicketFinderService;

@Service
@Transactional
public class TicketServiceImpl implements TicketFinderService {

	@Autowired
	private ITicketRepository ticketRepository;

	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

}
