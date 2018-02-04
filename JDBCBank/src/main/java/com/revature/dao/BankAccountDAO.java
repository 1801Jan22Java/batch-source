package com.revature.dao;

import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.User;

public interface BankAccountDAO {
	
	public void createAccount(String accountType, User user);
	public void deleteAccountById(int id, User user);
	public List<BankAccount> viewBankAccounts(User user);
}
