package com.revature.dao;

import java.util.List;

import com.revature.beans.Balance;

public interface BalanceDao {
	public String filename = "connection.properties";
	
	public List<Balance> getBalances();
	public Balance getBalanceByID(int id);
	public int addBalance(double initBalance);


}
