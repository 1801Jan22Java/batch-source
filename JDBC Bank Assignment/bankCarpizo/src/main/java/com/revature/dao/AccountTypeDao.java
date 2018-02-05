package com.revature.dao;

import java.util.List;

import com.revature.beans.AccountType;

public interface AccountTypeDao {
	List<AccountType> getAllAccountTypes();
	AccountType getAccountTypeById(int id);
}
