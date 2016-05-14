package com.TicketService.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Customer{
	@Id
	@GeneratedValue
	private long id;

	private String name;
	private String address;
	private String email;

	@Enumerated(EnumType.STRING)
	private Role role;

	
	
	@OneToMany(mappedBy = "bookedBy")	
	private Set<Ticket> tickets;
	public long getId(){
		return this.id;
	}

}
