package com.revature.dao;

import java.util.List;

import com.revature.beans.BankAccount;

public interface BankAccountDao {

	public List<BankAccount> getBankAccounts();
	public BankAccount getBankAccountById(int id);
	public int viewBalance(int id);
	public boolean withdrawFromAccount(int id, int amount);
	public boolean makeDeposit(int id, int amount);
	public boolean deleteAccount(int id);
	
	
}
