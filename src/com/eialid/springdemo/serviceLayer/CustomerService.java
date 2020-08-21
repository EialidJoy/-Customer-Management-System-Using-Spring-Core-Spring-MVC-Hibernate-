package com.eialid.springdemo.serviceLayer;

import java.util.List;

import com.eialid.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer ShowPrepopulateForm(int theId);

	public void Delete(int theId); 

}
