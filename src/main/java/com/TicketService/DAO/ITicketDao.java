package com.TicketService.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.TicketService.model.Ticket;

@Component
public interface ITicketDao extends JpaRepository<Ticket, Long> {
//	
//	@Query("select t from Ticket t join t.Movie m join t.Info i where  m.movie_id = :movieId and i.screeningDate between :startDate And :endDate")
//	public List<Ticket> getTicketByMovieAndDate(@Param("movieId") long movieId, @Param("startDate")  Date startDate, @Param("endDate") Date endDate);
//	
//	@Query("select t from Ticket t join t.bookedBy = :customerId ")
//	public List<Ticket> findForCustomer (@Param("customerId")long customerId);
//	
}
