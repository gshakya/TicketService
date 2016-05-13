package com.TicketService.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Info {
	@GeneratedValue
	@Id
	private long id;

	private String hall;

	@Temporal(TemporalType.DATE)
	private Date screeningDate;

}
