package com.TicketService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TicketService.Model.Ticket;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Long> {
//	
//	@Query("select t from Ticket t join t.Movie m join t.Info i where  m.movie_id = :movieId and i.screeningDate between :startDate And :endDate")
//	public List<Ticket> getTicketByMovieAndDate(@Param("movieId") long movieId, @Param("startDate")  Date startDate, @Param("endDate") Date endDate);
//	
//	@Query("select t from Ticket t join t.bookedBy = :customerId ")
//	public List<Ticket> findForCustomer (@Param("customerId")long customerId);
//	
}
