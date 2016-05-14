package com.TicketService.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Movie {
	@GeneratedValue
	@Id
	private long movieId;	
	private String movieName;
	private String desciption;	
	@OneToOne
	private Info details;
	@OneToMany(mappedBy = "movie")
	private Set<Ticket> allocatedTickets = new HashSet<Ticket>();

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movie_name) {
		this.movieName = movie_name;
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
		if(ticket.getMovie()==null){
			ticket.setMovie(this);
		}
	}

	public Info getDetails() {
		return details;
	}

	public void setDetails(Info details) {
		this.details = details;
	}
	
	
	
}
