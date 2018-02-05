package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.util.IllegalAmountException;
import com.revature.util.IllegalDeleteException;
import com.revature.util.IllegalWithdrawException;

public interface AccountDao {
	
	public void createAccount(Account acc);
	public List<Account> getUserAccounts(int userId);
	public Account getAccountById(int id);
	public void delete(int id) throws IllegalDeleteException;
	public void deposit(int id, double amt) throws IllegalAmountException;
	public void withdraw(int id, double amt) throws IllegalWithdrawException, IllegalAmountException;
	
}
