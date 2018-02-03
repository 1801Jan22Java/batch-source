package com.revature.dao;

import java.util.List;

import Beans.AccountType;

public interface AccountTypeDao {
	public List <AccountType> getAccountType();
	public AccountType getAccountTypeById(int id);
}
