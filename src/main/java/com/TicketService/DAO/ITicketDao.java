package com.TicketService.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TicketService.model.Ticket;

public interface ITicketDao extends JpaRepository<Ticket, Long> {
	
	@Query("select t from Ticket t join t.Movie m join t.Info i where  m.movie_id = :movieId and i.screeningDate between :startDate And :endDate")
	public List<Ticket> getTicketByMovieAndDate(long movieId, Date startDate, Date endDate);
	
}
