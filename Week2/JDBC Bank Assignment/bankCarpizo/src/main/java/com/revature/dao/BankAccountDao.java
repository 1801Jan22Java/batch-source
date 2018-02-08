package com.revature.dao;

import java.util.List;

import com.revature.beans.AccountType;
import com.revature.beans.BankAccount;
import com.revature.beans.User;

public interface BankAccountDao 
{
	List<BankAccount> getBankAccounts();
	BankAccount getBankAccountById(int id);
	void createBankAccount(BankAccount account);
	void deleteBankAccount(BankAccount account);
	void updateBankAccount(BankAccount account, User user, float balance, AccountType type);
}
