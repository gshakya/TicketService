package com.TicketService.service;

import java.util.List;
import com.TicketService.model.Customer;
import com.TicketService.model.Staff;

public interface IUsermanagementService {
	
	public void addCustomer(Customer customer);	
	
	public boolean removeCustomer(int id);
	
	public void updateCustomer(Customer customer);
	
	public List<Customer> findCustomerByName(String name);
	
	public List<Customer> findCustomerByEmail(String email);
	
	public void addStaff(Staff staff);
	
	public boolean removeStaff(int id);
		
	public void updateStaff(Staff staff);
	
	public List<Staff> findStaffByName(String name);
	
	public List<Staff> findStaffByEmail(String email);

}
