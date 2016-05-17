package com.TicketService.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TicketService.Model.Movie;
import com.TicketService.Repository.IMovieRepository;
import com.TicketService.Service.MovieUtilityService;

@Service
public class MovieUtilityServiceImpl implements MovieUtilityService {
	@Autowired
	private IMovieRepository movieRepo;

	@Override
	public void update(Movie m) {
		movieRepo.save(m);
	}

	@Override
	public void add(Movie m) {
		movieRepo.save(m);
	}

	@Override
	public void delete(long id) {
		movieRepo.delete(id);
	}

}
