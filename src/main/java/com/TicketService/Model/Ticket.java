package com.TicketService.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ticket {
	@GeneratedValue
	@Id
	private long ticketId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="movie_id")
	private Movie movie;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer bookedBy;	
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
		if(!movie.getAllocatedTickets().contains(this))
			movie.addTickets(this);
	}
	
	public Customer getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(Customer bookedBy) {
		this.bookedBy = bookedBy;
		if(!bookedBy.getTickets().contains(this)){
			bookedBy.addTicket(this);
		}
	}
	public long getTicketId() {
		return ticketId;
	}
	
	
}
