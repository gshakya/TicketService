package com.TicketService.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginDetail {
	@Id
	private String username;
	private Role role;
	
	
	public LoginDetail (String username){
		this.username=username;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getUsername() {
		return username;
	}
	
	
	
}
