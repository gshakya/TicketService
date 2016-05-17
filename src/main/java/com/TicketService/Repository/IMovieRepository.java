package com.TicketService.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.TicketService.Model.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {
	
	public List<Movie> findMovieByMovieName(String name);
	
	@Query("Select m from Movie m where m.movieName like %:name%")
	public List<Movie> findMovieWithNameLike(@Param("name") String name);
	
	
	@Query("Select m.details.totalSeats from Movie m where m.movieId = :movieId")
	public int getCapacity(@Param("movieId") long movieId);
	
	@Query("Select m from Movie m join m.details d where  m.movieName like %:movieName% and d.screeningDate = :screeningDate")
	public List<Movie> findMovieByNameAndDate(@Param("movieName")String movieName , @Param("screeningDate")Date screeningDate );
}
