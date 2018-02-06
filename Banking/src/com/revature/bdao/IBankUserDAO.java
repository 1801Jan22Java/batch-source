package com.revature.bdao;

import java.util.List;

import com.revature.bbeans.BankUser;

public interface IBankUserDAO {
	public BankUser userInDatabase(String username, String password);
	public BankUser addBankUser(String first, String last, String username, String password);
	public void removeBankUser(int userID);
	public List<BankUser> viewAllBankUsers();
	public BankUser viewBankUser(int userID);
	public void updateAccountPassword(int userID, String newPassword);
}
