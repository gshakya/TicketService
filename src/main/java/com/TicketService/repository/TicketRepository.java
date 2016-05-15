package com.TicketService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TicketService.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
