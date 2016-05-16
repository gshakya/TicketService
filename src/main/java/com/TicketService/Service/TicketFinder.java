package com.TicketService.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TicketService.Model.Customer;
import com.TicketService.Model.Info;
import com.TicketService.Model.Movie;
import com.TicketService.Model.Ticket;
import com.TicketService.Repository.IMovieRepository;

@Service
@Transactional
public class TicketFinder {
	@Autowired
	private IMovieRepository movieDao;

	// @Autowired
	// private ITicketDao ticketDao;

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

	public List<Movie> findByName(String name) {
		return movieDao.findMovieWithNameLike(name);
	}

	public void addMovie(String movieName, String movieDesc, String hallName, int totalSeats, Date screeningDate,
			double price) {
		Movie m = new Movie();

		Info i = new Info();
		i.setHall(hallName);
		i.setPrice(price);
		i.setScreeningDate(screeningDate);
		i.setTotalSeats(totalSeats);

		m.setMovieName(movieName);
		m.setDescription(movieDesc);
		m.setDetails(i);
	}
}
