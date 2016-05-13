package com.TicketService.model;

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
	
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;
	@ManyToOne
	private Info details;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer bookedBy;	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff createdBy; 
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Info getDetails() {
		return details;
	}
	public void setDetails(Info details) {
		this.details = details;
	}
	public Customer getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(Customer bookedBy) {
		this.bookedBy = bookedBy;
	}

	
}
