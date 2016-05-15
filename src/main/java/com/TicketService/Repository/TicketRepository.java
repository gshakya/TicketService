package com.TicketService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TicketService.Model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
