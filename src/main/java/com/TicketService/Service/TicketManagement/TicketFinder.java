package com.TicketService.Service.TicketManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.TicketService.DAO.IMovieDao;
import com.TicketService.DAO.ITicketDao;
import com.TicketService.model.Customer;
import com.TicketService.model.Movie;
import com.TicketService.model.Ticket;

public class TicketFinder {
	@Autowired
	private IMovieDao movieDao;

	@Autowired
	private ITicketDao ticketDao;

	public Ticket buyTicket(long movieId, Customer c) {
		Movie m = movieDao.findOne(movieId);
		if (m.getDetails().getTotalSeats() > m.getAllocatedTickets().size()) {
			Ticket t = new Ticket();
			t.setBookedBy(c);
			t.setMovie(m);
			return t;
		}
		return null;
	}
	
	public List<Movie> findByName(String name){
		return movieDao.findMovieWithNameLike(name);
	}
}
