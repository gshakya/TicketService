package com.TicketService.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
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
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String address;
	private String email;
	@OneToOne
	@JoinColumn(name="loginName")
	private LoginDetail userInfo;

	@OneToMany(mappedBy = "bookedBy")
	private Set<Ticket> tickets = new HashSet<Ticket>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoginDetail getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(LoginDetail userInfo) {
		this.userInfo = userInfo;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
