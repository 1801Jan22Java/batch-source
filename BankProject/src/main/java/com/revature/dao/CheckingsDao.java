package com.revature.dao;

import com.revature.beans.Checkings;

public interface CheckingsDao {


	public Checkings getCheckingsByUserId(int userId);
	
	public void updateCheckingsBalance(int userId, double checkingsBalance);
	
}
