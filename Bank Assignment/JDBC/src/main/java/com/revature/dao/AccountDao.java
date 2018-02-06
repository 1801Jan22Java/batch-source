package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Members;

public interface AccountDao {
		public List<Account> getAccounts(Members user);
		public float updateBalance(Account account);
		public void createAccount(Members user, String accountName);
		
		public void deposit(Members user, Account account, double amount);
		public void withdraw(Members user, Account account, double amount);
		public void deleteAccount(Account account);
		
	

}
