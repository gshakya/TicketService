package com.TicketService.Usermanagement.repository;

import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.TicketService.Usermanagement.repository.impl.IUsermanagementRepository;
import com.TicketService.model.Customer;

@Transactional
@Repository
@SuppressWarnings("unchecked")
public class UsermanagementRepository extends BaseRepository<Customer> implements IUsermanagementRepository {

	@Override
	public Object add(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Customer> searchByName(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Customer> searchByEmail(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer patchMovie(int id, String title, String description) {
		// TODO Auto-generated method stub
		return null;
	}
}
