package com.revature.dao;

import com.revature.beans.BankAccount;
import com.revature.beans.User;

public interface BankAccountDAO {
	
	public void createAccount(BankAccount b);
	public void deleteAccount(BankAccount b);
	public BankAccount viewBankAccounts(User user);
}
