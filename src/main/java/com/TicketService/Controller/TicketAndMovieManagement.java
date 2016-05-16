package com.TicketService.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.TicketService.Model.Customer;
import com.TicketService.Model.Movie;
import com.TicketService.Model.Ticket;
import com.TicketService.ServiceImpl.TicketFinderServiceImpl;

@Controller
// @RequestMapping("/movie")
public class TicketAndMovieManagement {

	@Autowired
	private TicketFinderServiceImpl ticketFinder;

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
	public String findMovie(@RequestParam("movieName") String movieName, @RequestParam("searchDate") String searchDate,
			Model model) throws ParseException {
		logger.debug("I'm here");
		List<Movie> movies;
		if (searchDate == "") {
			movies = ticketFinder.findByName(movieName);
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date sDate = simpleDateFormat.parse(searchDate);
			movies = ticketFinder.findByNameAndDate(movieName, sDate);
		}
		System.out.println(movies.size());

		model.addAttribute("movies", movies);

		return "movieList";
	}
	
	@RequestMapping (value = "/movie/buyTicket" , method = RequestMethod.POST , headers= { "Accept=application/json" })
	public String buyTicket(@RequestParam("movieId")  String movieId, Model model ){
		System.out.println("Buy Ticket Conformation" + movieId);
		Customer c = new Customer();
		Ticket t = ticketFinder.buyTicket(Long.parseLong(movieId), c);	
		model.addAttribute("ticket", t);
		return "ticketConformation";
		
	}

}
