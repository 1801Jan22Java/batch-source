package com.revature.dao;

import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();
	public void addCustomer(String username, String password,String f_name,String l_name);
	public void login(String username, String password);
	public void deleteAccount();
	public void addCustomer_Super(String f_name,String l_name,String username,String password);
 
}
