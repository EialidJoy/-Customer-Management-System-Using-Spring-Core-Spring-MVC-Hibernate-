package com.eialid.springdemo.serviceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eialid.springdemo.dao.CustomerDao;
import com.eialid.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	
	
	@Transactional
	public List<Customer> getCustomers() {
		
		
		return customerDao.getCustomers();
	}



	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDao.saveCustomer(theCustomer);
		
	}



	@Override
	@Transactional
	public Customer ShowPrepopulateForm(int theId) {
		
		return customerDao.ShowPrepopulateForm(theId);	
	}



	@Override
	@Transactional
	public void Delete(int theId) {
		customerDao.Delete(theId);
		
	}

}
