package com.TicketService.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.TicketService.Model.Movie;
import com.TicketService.Service.TicketFinder;

@Controller
// @RequestMapping("/movie")
public class TicketAndMovieManagement {

	@Autowired
	private TicketFinder ticketFinder;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public String movieHome() {
		return "movieList";
	}

	@RequestMapping(value = "/movie/findMovie", method = RequestMethod.GET)
	public String findMovie(@RequestParam("movieName") String movieName, Model model) {
		logger.debug("I'm here");
		System.out.println("I'm Here");
		List<Movie> movies = ticketFinder.findByName(movieName);
		for (Movie m : movies){
			System.out.println("Movie:"+m);
		}
		
		return "movieList";
	}

}
