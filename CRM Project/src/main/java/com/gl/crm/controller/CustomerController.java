package com.gl.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.crm.entity.Customer;
import com.gl.crm.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		System.out.println("request recieved");
		List<Customer>theCustomer = customerService.findAll();
		theModel.addAttribute("Customer", theCustomer);
		return "list.Customer";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("Customer", theCustomer);
		return "Customer.Form";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer = customerService.findById(theId);

		theModel.addAttribute("Customer", theCustomer);
		// send over to our form
		return "Customer.Form";
	}
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		System.out.println(id);
		Customer theCustomer;
		if (id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);

		}else
			theCustomer = new Customer(firstName, lastName, email);
		customerService.save(theCustomer);
		return "redirect:/customer/list";

	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		// delete the customer details
		customerService.deleteById(theId);
		// redirect to /customer/list
		return "redirect:/customer/list";
	}
}
