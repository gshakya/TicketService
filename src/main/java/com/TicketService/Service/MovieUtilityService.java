package com.TicketService.Service;

import com.TicketService.Model.Movie;

public interface MovieUtilityService {
	public void update(Movie m);

	public void add(Movie m);

	public void delete(long id);
}
