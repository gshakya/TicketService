package com.TicketService.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TicketService.Model.Customer;
import com.TicketService.Repository.ICustomerRepository;
import com.TicketService.Service.CustomerManagementService;

@Service
@Transactional
public class CustomerManagementServiceImpl implements CustomerManagementService {
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public List<Customer> findCustomerByName(String name) {
		List<Customer> customers = customerRepository.findByNameLike(name);
		return customers;
	}

	@Override
	public List<Customer> findCustomerByEmail(String email) {
		List<Customer> customers = customerRepository.findByEmailLike(email);
		return customers;
	}

	@Override
	public List<Customer> findCustomerByNameAndEmail(String CustomerName, String CustomerEmail) {
		List<Customer> customers = customerRepository.findCustomerByNameAndEmail(CustomerName, CustomerEmail);
		return customers;
	}

	@Override
	public Customer findOne(long id) {
		Customer Customer = customerRepository.findById(id);
		return Customer;
	}

	@Override
	public void add(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void update(Customer customer) {
		customerRepository.updateById(customer.getId(), customer.getName(), customer.getAddress(), customer.getEmail());
	}

	@Override
	public void remove(long id) {
		customerRepository.delete(id);
	}

	@Override
	public Customer findCustomerByUserName(String uname) {
		customerRepository.findCustomerByUserName(uname);
		return null;
	}
}
