package com.gl.customer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.customer.model.Customer;
import com.gl.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/show")
	public String showCustomer(Model std) {

		List<Customer> customers = new ArrayList<>();
		customers = customerService.getAll();
		System.out.println("Created empty customerService object" + customerService);

		std.addAttribute("customers", customers);
		System.out.println("Added list<Customer> customers object to the model atribute");

		return "customers";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model std) {

		Customer newCustomer = new Customer();
		std.addAttribute("customer", newCustomer);

		return "customer-form";
	}

	@RequestMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customer theCustomer;
		if (id == 0) {
			// add new student
			theCustomer = new Customer(firstName, lastName, email);

		} else {
			// update the student
			theCustomer = customerService.getById(id);
			System.out.println("Customer to be updated-" + theCustomer.toString());
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);
		}
		System.out.println("received the Customer from the customer form for upsert");
		System.out.println(theCustomer.toString());
		customerService.saveOrUpdateCustomer(theCustomer);
		System.out.println("Customer persisted!");
		return "redirect:/customer/show";
	}

	@RequestMapping("/search")
	public String searchCustomer(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("email") String email, Model theModel) {
		// if search fields are empty
		if (firstName.isEmpty() && lastName.isEmpty() && email.isEmpty()) {
			return "redirect:/customer/show";
		} else {
			List<Customer> customer = customerService.getByName(firstName, lastName, email);
			theModel.addAttribute("customers", customer);
			return "customers";
		}

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormFroUpdate(@RequestParam("customerId") int id, Model theModel) {
		Customer cust = customerService.getById(id);
		System.out.println("Going to update the customer- " + cust.toString());
		theModel.addAttribute("customer", cust);

		return "customer-form";
	}

	@RequestMapping("/delete")
	public String removeCustomer(@RequestParam("customerId") int id, Model theModel) {
		Customer cust = customerService.getById(id);
		customerService.removeCustomer(id);
		System.out.println("Going to remove the customer- " + cust.toString());
		theModel.addAttribute("customer", cust);

		return "redirect:/customer/show";
	}

}
