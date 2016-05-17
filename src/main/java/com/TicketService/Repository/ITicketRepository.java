package com.TicketService.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TicketService.Model.Ticket;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Long> {
	
//	@Query("select t from Ticket t join t.Movie m join t.Info i where  m.movie_id = :movieId and i.screeningDate = :searchDate")
//	public List<Ticket> getTicketByMovieAndDate(@Param("movieId") long movieId, @Param("searchDate")  Date searchDate);
	
//	@Query("select t from Ticket t join t.bookedBy = :customerId ")
//	public List<Ticket> findForCustomer (@Param("customerId")long customerId);
//	
}
