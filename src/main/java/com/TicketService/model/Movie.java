package com.TicketService.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Movie {
	@GeneratedValue
	@Id
	private long movie_id;
	
	private String movie_name;
	
	@OneToMany(mappedBy = "movie")
	private Set<Ticket> allocatedTickets;

}
