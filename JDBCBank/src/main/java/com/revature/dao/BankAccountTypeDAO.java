package com.revature.dao;

import java.util.List;

import com.revature.beans.AccountType;
import com.revature.beans.BankAccount;

public interface BankAccountTypeDAO {

	public List<BankAccount> getBankTypes();
	public AccountType getBankTypeById(int id);
}
