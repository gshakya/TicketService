package com.TicketService.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Staff {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String address;
	private String email;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "loginName")
	private LoginDetail userInfo;
	
	public String getName() {
		return name;
	}
	
	public long getId(){
		return id;
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
	
}
