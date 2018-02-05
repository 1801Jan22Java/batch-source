package com.revature.dao;

import java.util.List;

import com.revature.beans.AccountType;

public interface AccountTypeDao {
	public List <AccountType> getAccountType();
	public AccountType getAccountTypeById(int id);
}
