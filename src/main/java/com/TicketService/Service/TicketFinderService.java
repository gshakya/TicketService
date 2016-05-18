package com.TicketService.Service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TicketService.Model.Customer;
import com.TicketService.Model.Movie;
import com.TicketService.Model.Ticket;

@Service
public interface TicketFinderService {

	public void addMovie(String movieName, String movieDesc, String hallName, int totalSeats, Date screeningDate,
			double price);

	public Ticket buyTicket(long movieId, Customer c);

	public List<Movie> findByName(String name);

	public Movie findMovieById(long id);

	public List<Movie> findByNameAndDate(String name, Date searchDate);

}
