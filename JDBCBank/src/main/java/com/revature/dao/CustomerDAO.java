package com.revature.dao;

import com.revature.beans.Customer;

public interface CustomerDAO {
	
	public Customer getCustByUsername(String username);
	
	public void createNewCustomer(String username, String password);

	public int getSuperStatus(String username);

	public String validatePassword(String password);

//	public List<Customer> getCustomers();
	
//	public Customer getCustomerById(int userId);
	
	
//	public int addNewCustomer(Customer customer); 
	
}
