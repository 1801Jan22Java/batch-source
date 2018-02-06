package com.revature.dao;

import com.revature.beans.Savings;

public interface SavingsDao {

	public Savings getSavingsByUserId(int userId);
	
	public void updateSavingsBalance(int userId, double savingsBalance);
	
}
