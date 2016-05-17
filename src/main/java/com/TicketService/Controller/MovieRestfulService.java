package com.TicketService.Controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TicketService.Model.Movie;
import com.TicketService.Repository.IMovieRepository;

@Controller
public class MovieRestfulService {
	@Autowired
	private IMovieRepository movieRepo;
	
	@RequestMapping(value = "movie/getMoviesJson", method = RequestMethod.GET)
	public @ResponseBody List<Movie> addCart(Locale locale, Model model) {
		System.out.println("---Get JSON Object------");
		return movieRepo.findAll();
		
	}

}
