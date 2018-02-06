package com.revature.dao;

import com.revature.beans.Account;

public interface AccountDAO {
	
	public Account getByAccountId(int accountId);
	
	public void addAccount(double amount);

}
