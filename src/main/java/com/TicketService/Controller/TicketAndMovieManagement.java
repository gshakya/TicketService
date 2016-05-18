package com.TicketService.Controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.TicketService.Model.Customer;
import com.TicketService.Model.Movie;
import com.TicketService.Model.Ticket;
import com.TicketService.Service.CustomerManagementService;
import com.TicketService.Service.MovieUtilityService;
import com.TicketService.Service.TicketFinderService;

@Controller
// @RequestMapping("/movie")
public class TicketAndMovieManagement {

	@Autowired
	private TicketFinderService ticketFinder;

	@Autowired
	private CustomerManagementService customerMgmtService;

	@Autowired
	private MovieUtilityService movieUtil;

	public void setMovieUtil(MovieUtilityService movieUtil) {
		this.movieUtil = movieUtil;
	}

	public void setTicketFinder(TicketFinderService ticketFinder) {
		this.ticketFinder = ticketFinder;
	}

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

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
		model.addAttribute("movies", movies);
		return "movieList";
	}

	@RequestMapping(value = "/movie/buyTicket", method = RequestMethod.POST)
	public String buyTicket(@RequestParam("movieId") String movieId, Model model) {
		System.out.println("--- Buy Ticket Conformation----" + movieId);
		

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		Customer c;
		c = customerMgmtService.findCustomerByUserName(username);
		

		Ticket t = ticketFinder.buyTicket(Long.parseLong(movieId), c);
		model.addAttribute("ticket", t);

		System.out.println(t);
		return "ticketConformation";
	}

	@RequestMapping(value = "/movie/delete/{id}", method = RequestMethod.GET)
	public String editDelete_get(@PathVariable Long id, Model model) {
		movieUtil.delete(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/movie/edit/{id}", method = RequestMethod.GET)
	public String editMovie_get(@PathVariable Long id, Model model) {
		model.addAttribute("movie", ticketFinder.findMovieById(id));
		System.out.println("-- Movie Id" + id);
		return "editMovie";
	}

	@RequestMapping(value = "/movie/edit", method = RequestMethod.POST)
	public String editMovie_post(@ModelAttribute Movie movie) throws Exception {
		System.out.println("--- Edit Movie entered");
		movieUtil.update(movie);
		return "movieList";
	}

	@RequestMapping(value = "/movie/new", method = RequestMethod.GET)
	public String saveMovie_get(Model model) {
		System.out.println("-----inside get method----");
		model.addAttribute("movie", new Movie());
		return "editMovie";
	}

}
