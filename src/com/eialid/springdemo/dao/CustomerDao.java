package com.eialid.springdemo.dao;

import java.util.List;

import com.eialid.springdemo.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer ShowPrepopulateForm(int theId);

	public void Delete(int theId);

}
