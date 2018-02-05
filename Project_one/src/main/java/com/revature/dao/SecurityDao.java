package com.revature.dao;

import java.util.List;

import com.revature.beans.Customer;

public interface SecurityDao {
	public List<Customer> getCustomers();
	public boolean check_Availability(String username);
	public boolean check_AccountNumber(int accounts);
}
