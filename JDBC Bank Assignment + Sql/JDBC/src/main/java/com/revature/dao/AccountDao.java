package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Members;

public interface AccountDao {
		public List<Account> getAccounts();

		public void createAccount(String username, String firstName, String lastName, String password, long num);
		
		public void deposit(long amount, String username);
		public void withdraw(long amount, String username);

		
	

}
