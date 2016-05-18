package com.TicketService.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TicketService.Model.Staff;
import com.TicketService.Repository.IStaffRepository;
import com.TicketService.Service.CustomerManagementService;
import com.TicketService.Service.StaffManagementService;

@Service
@Transactional
public class StaffManagementServiceImpl implements StaffManagementService {
	@Autowired
	private IStaffRepository staffRepository;

	@Override
	public List<Staff> findStaffByName(String name) {
		List<Staff> staffs = staffRepository.findByNameLike(name);
		return staffs;
	}

	@Override
	public List<Staff> findStaffByEmail(String email) {
		List<Staff> staffs = staffRepository.findByEmailLike(email);
		return staffs;
	}

	@Override
	public List<Staff> findStaffByNameAndEmail(String staffName, String staffEmail) {
		List<Staff> staffs = staffRepository.findStaffByNameAndEmail(staffName, staffEmail);
		return staffs;
	}

	@Override
	public Staff findOne(long id) {
		Staff staff = staffRepository.findById(id);
		return staff;
	}

	@Override
	public void add(Staff staff) {
		staffRepository.save(staff);
	}

	@Override
	public void update(Staff staff) {
		staffRepository.updateById(staff.getId(), staff.getName(), staff.getAddress(), staff.getEmail());
	}
	
	@Override
	public void remove(long id) {
		staffRepository.delete(id);
	}
}
