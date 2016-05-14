package com.TicketService.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.TicketService.DAO.CustomerDAO;
import com.TicketService.model.Customer;
import com.TicketService.model.Staff;

@Transactional
@Service
public class UsermanagementService implements IUsermanagementService{

	private CustomerDAO customerDAO ;
	
	public UsermanagementService(){
		customerDAO = new CustomerDAO();
	}
	@Override
	public void addCustomer(Customer customer) {
		customerDAO.add(customer);
		
	}

	@Override
	public boolean removeCustomer(int id) {
		customerDAO.delete(id);
		return false;
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.update(customer);
		
	}
	
	@Override
	public List<Customer> findCustomerByName(String key) {
		return customerDAO.findCustomerByName(key);
	}

	@Override
	public List<Customer> findCustomerByEmail(String key) {
		return customerDAO.findCustomerByEmail(key);
	}

	@Override
	public void addStaff(Staff staff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeStaff(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateStaff(Staff staff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Staff> findStaffByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Staff> findStaffByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
/*
	private MovieRepository movieRepository ;

	public MovieService(){
		movieRepository = new MovieRepository();
	}
	
	public Movie addMovie(Movie movie) {
		return movieRepository.add(movie);
	}

	public List<Movie> getAllMovies() {
		return movieRepository.getAll();
	}

	public Movie getMovie(int id) {
		Movie movie = movieRepository.get(id);
		return movie;
	}

	public Movie updateMovie(Movie movie) {
		return movieRepository.update(movie);
	}

	public boolean deleteMovie(int id) {
		return movieRepository.delete(id);
	}

	public Movie patchMovie(int id, String title, String content) {
		return movieRepository.patchMovie(id, title, content);
	}

	public List<Movie> searchMovie(SearchCriteria criterias, String key) {
		switch(criterias){
			case TITLE:
				return movieRepository.searchByTitle(key);
			case GENRE:
				return movieRepository.searchByGenre(key);
			case RATING:
				return movieRepository.searchByRating(key);
			case YEAR:
				return movieRepository.searchByYear(key);
			case ASTIST_NAME:
				return movieRepository.searchByNameOfArtist(key);
			case DIRECTOR_NAME:
				return movieRepository.searchByNameOfDirector(key);
		default:
			break;
		}	
		return new ArrayList<Movie>();
	}
*/

}
