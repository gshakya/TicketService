package com.TicketService.model;

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
	@OneToOne
	private Info details;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer bookedBy;

	
}
