package com.TicketService.Controller.Usermangement;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.TicketService.model.Customer;
import com.TicketService.model.Staff;
import com.TicketService.service.UsermanagementService;

@Controller
public class UserManagement {
	
	UsermanagementService usermanagementService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/staff", method = RequestMethod.GET)
	public String movieHome() {
		return "staffList";
	}

	@RequestMapping(value = "/staff/findStaff", method = RequestMethod.GET)
	public String findStaff(@RequestParam("staffName") String staffName, Model model) {
		//logger.debug("Find staff by name");
		System.out.println("Find staff by name");
		List<Staff> staffs = usermanagementService.findStaffByName(staffName);
		for (Staff s : staffs){
			System.out.println("Staff: " + s);
		}
		
		return "staffList";
	}
	
	//Registration
	/*@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
	    Customer customer = new Customer();
	    model.addAttribute("user", customer);
	    return "register";
	}*/
	@RequestMapping(method = RequestMethod.POST)
    public String processRegistration(WebRequest request,
            Model model) {
		 Customer customer = new Customer(); 
		usermanagementService.addCustomer(customer);
         
        return "RegistrationSuccess";
    }
}
