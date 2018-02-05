package com.revature.dao;

import java.util.List;

import com.revature.beans.BankAccount;

public interface BankAccountDao {

	public List<BankAccount> getBankAccounts();
	public BankAccount getBankAccountById(int id);
	public double viewBalance(int id);
	public double withdrawFromAccount(int userid, int accountid, double amount);
	public double makeDeposit(int userid, int accountid, double amount);
	public int deleteAccount(int id);
	public int addAccount(BankAccount account);
	
	
}
