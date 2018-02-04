package src.com.revature.dao;

import java.util.List;

import src.com.revature.beans.Customer;

public interface CustomerDao {
	public List<Customer> getCustomer();
	public Customer getCustomerById(int userid);
	public int addACustomer(Customer customer);

}
