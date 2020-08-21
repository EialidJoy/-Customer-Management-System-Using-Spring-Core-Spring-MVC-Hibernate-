package com.eialid.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eialid.springdemo.entity.Customer;
import com.eialid.springdemo.serviceLayer.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")	
	public String listCustomers(Model theModel) {
		
		List<Customer> customers=customerService.getCustomers();
		
		theModel.addAttribute("attCustomers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/forAddition")
	public String AddCustomer(Model theModel) {
		
		Customer theCustomer=new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String SaveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String ShowPrepopulateForm(@RequestParam("customerId") int theId, Model theModel) {
		
		Customer theCustomer=customerService.ShowPrepopulateForm(theId);
		
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String Delete(@RequestParam("customerId") int theId) {
		customerService.Delete(theId);
		return "redirect:/customer/list";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
