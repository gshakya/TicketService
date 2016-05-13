package com.TicketService.model;

import java.util.HashSet;
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
	private String desciption;	
	@OneToMany(mappedBy = "movie")
	private Set<Ticket> allocatedTickets = new HashSet<Ticket>();

	public long getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(long movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Set<Ticket> getAllocatedTickets() {
		return allocatedTickets;
	}

	public void addTickets(Ticket ticket) {
		allocatedTickets.add(ticket);
	}
	
	
	
}
