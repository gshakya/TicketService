package com.TicketService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TicketService.Model.Staff;

@Service
public interface StaffManagementService {
	public List<Staff> findStaffByName(String name);

	public List<Staff> findStaffByEmail(String email);

	public List<Staff> findStaffByNameAndEmail(String staffName, String staffEmail);

	public Staff findOne(long id);

	public void add(Staff staff);

	public void update(Staff staff);

	public void remove(long id);
}
