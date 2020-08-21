package com.eialid.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eialid.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired  //injecting sessionfactory object or dependency
	private SessionFactory sessionFactory;
	
	public List<Customer> getCustomers() {
		
		//creating session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//creating query
		
		Query<Customer> forList=currentSession.createQuery("from Customer", Customer.class);
		
		List<Customer> customersList=forList.getResultList();
		
		
		return customersList;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session session=sessionFactory.getCurrentSession();
		
		//save or update the customer
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer ShowPrepopulateForm(int theId) {
		
		Session session=sessionFactory.getCurrentSession();
		Customer theCustomer=session.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void Delete(int theId) {
		Session session=sessionFactory.getCurrentSession();
		Query theQuery=session.createQuery("delete from Customer where id=:theCustomerId");
		theQuery.setParameter("theCustomerId", theId);
		theQuery.executeUpdate();
		
	}

}
