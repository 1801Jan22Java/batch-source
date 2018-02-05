package com.revature.dao;

import java.util.List;

import com.revature.vo.BankUserVo;

public interface BankUserDao {

	List<BankUserVo> getBankUser();				  	// get list of all users' info
	BankUserVo getBankUserByName(String name);	  	// get a user's info by name
	int ifUserExist(String name) ;				  	// check if the user exist
	int ifUserExist(int userId) ;
	int ifRightPW (String name, String password); 	// check if it's right password
	List<BankUserVo> getBankUserWithTotalBalance();	// get list of all users' info with eachone's balance
	void createBankUser (String username, String password);	// create new user
	void deleteUser(int userId);
	
}
