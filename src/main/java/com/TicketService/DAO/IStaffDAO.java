package com.TicketService.DAO;

import java.util.List;

import com.TicketService.model.Staff;

public interface IStaffDAO extends IBaseDAO<Staff> {

	public void addStaff(Staff staff);

	public boolean removeStaff(int id);

	public void updateStaff(Staff staff);

	public List<Staff> findStaffByName(String name);

	public List<Staff> findStaffByEmail(String email);

}