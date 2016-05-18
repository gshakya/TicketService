package com.TicketService.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.TicketService.Model.Customer;
import com.TicketService.Model.Role;
import com.TicketService.Service.CustomerManagementService;
import com.TicketService.Service.IEmailSenderService;

@Controller
public class CustomerManagement {
	@Autowired
	CustomerManagementService customerManagementService;
	
	@Autowired
	private IEmailSenderService emailSenderService;

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String CustomerHome() {
		return "FindCustomer";
	}

	@RequestMapping(value = "/customer/findCustomer", method = RequestMethod.GET)
	public String findCustomer(@RequestParam("customerName") String customerName,
			@RequestParam("customerEmail") String customerEmail, Model model) {
		List<Customer> customers = new ArrayList<Customer>();
		if (customerName.isEmpty() && customerEmail.isEmpty()) {
			model.addAttribute("errorMessage", "Please input criterian to find!");
		} else if (customerName.isEmpty()) {
			customers = customerManagementService.findCustomerByEmail(customerEmail);
		} else if (customerEmail.isEmpty()) {
			customers = customerManagementService.findCustomerByName(customerName);
		} else {
			customers = customerManagementService.findCustomerByNameAndEmail(customerName, customerEmail);
		}
		model.addAttribute("customers", customers);
		return "FindCustomer";
	}

	@RequestMapping(value = "/customer/addCustomer", method = RequestMethod.GET)
	public String showAddCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("page", "addCustomer");
		model.addAttribute("usernameDisabled", "");
		return "NewCustomer";
	}

	@RequestMapping(value = "/customer/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute Customer customer, BindingResult errors, HttpServletRequest request) {
		customerManagementService.add(customer);
		return "FindCustomer";
	}

	@RequestMapping(value = "/customer/updateCustomer/{id}", method = RequestMethod.GET)
	public String viewEditCustomer(@PathVariable Long id, Model model) {
		model.addAttribute("customer", customerManagementService.findOne(id));
		model.addAttribute("page", "updateCustomer");
		model.addAttribute("usernameDisabled", "true");
		model.addAttribute("RegisteredViewer", Role.ROLE_REGISTERVIEWER);
		return "NewCustomer";
	}

	@RequestMapping(value = "/customer/updateCustomer", method = RequestMethod.POST)
	public String editCustomer(@ModelAttribute Customer customer, BindingResult errors, HttpServletRequest request)
			throws Exception {
		if (errors.hasErrors()) {
			return null;
		}
		customerManagementService.update(customer);
		return "FindCustomer";
	}

	@RequestMapping(value = "/customer/removeCustomer/{id}", method = RequestMethod.GET)
	public String removeCustomer(@PathVariable Long id, Model model) throws Exception {

		customerManagementService.remove(id);
		return "FindCustomer";
	}

	// Registration
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("RegisteredViewer", Role.ROLE_REGISTERVIEWER);
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addRegister(@ModelAttribute Customer customer, BindingResult errors, HttpServletRequest request,
			Model model) {
		customerManagementService.add(customer);
		String toAddr = "gr.skya@gmail.com";
		String subject = "Customer Added";
		String body = "Customer Name:"+customer.getName()+"\\nCustomer Email:"+customer.getEmail();
		emailSenderService.sendEmail(toAddr, subject, body);
		if (errors.hasErrors()) {
			System.out.println("error:" + errors.toString());
		}
		model.addAttribute("customerForm", customer);
		return "RegistrationSuccess";
	}
}
