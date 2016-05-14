package com.TicketService.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TicketService.model.Movie;

public interface IMovieDao extends JpaRepository<Movie, Long> {
	
	public List<Movie> findMovieByMovieName(String name);
	
	@Query("Select m from Movie m where m.movieName like %:name%")
	public List<Movie> findMovieWithNameLike(@Param("name") String name);
	
	
	@Query("Select m.details.totalSeats from Movie m where m.movieId = :movieId")
	public int getCapacity(@Param("movieId") long movieId);
	
	@Query("Select m from Movie join t.Info i where  m.movieName like %:movieName% and i.screeningDate between :startDate And :endDate")
	public List<Movie> findMovieByNameAndDate(@Param("movieName")String movieName , @Param("startDate")Date startDate , @Param("endDate")Date endDate);
}
