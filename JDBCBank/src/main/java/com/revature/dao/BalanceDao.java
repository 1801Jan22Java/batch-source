package com.revature.dao;

import java.util.List;

import com.revature.beans.Balance;

public interface BalanceDao {
	
	public List<Balance> getBalances();
	public Balance getBalanceByID(int id);

}
