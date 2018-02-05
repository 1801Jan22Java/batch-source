package com.revature.dao;

import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDAO {
	
	public Customer checkIfCustomerExist(String username);

	public List<Customer> getCustomers();
	
	public Customer getCustomerById(int userId);
	
	
	public int addNewCustomer(Customer customer); 
	
}
