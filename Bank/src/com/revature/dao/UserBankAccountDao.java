package com.revature.dao;

import java.util.List;

import com.revature.beans.User;
import com.revature.beans.UserBankAccount;

public interface UserBankAccountDao {
	
	public List<UserBankAccount> getUserBankAccounts();
	public UserBankAccount getUserBankAccountbyId(int userid, int account);
	public int addUserBankAccount(UserBankAccount uba);
	public int numOfAccounts(User user);
}
