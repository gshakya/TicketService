package com.TicketService.Service;

import org.springframework.stereotype.Service;

import com.TicketService.Model.Movie;

@Service
public interface MovieUtilityService {
	public void update(Movie m);

	public void add(Movie m);

	public void delete(long id);
}
