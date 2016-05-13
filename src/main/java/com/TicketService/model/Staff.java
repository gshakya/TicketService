package com.TicketService.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Staff {
	@Id
	@GeneratedValue

	private long id;

	private String name;
	private String address;
	private String email;

	@Enumerated(EnumType.STRING)
	private Role role;

}
