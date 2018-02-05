package com.revature.dao;

import com.revature.beans.Account;
import com.revature.beans.User;

public interface AccountDao {
	public boolean addAccount(User myUser, String accountType, String accountName);
	public boolean getAccounts(User myUser);
	public boolean withdrawAmount(float amount, int currentAccountIndex, User thisUser);
	public boolean depositAmount(float amount, int currentAccountIndex, User thisUser);
	public boolean closeAccount(int currentAccountIndex, User thisUser);
}
