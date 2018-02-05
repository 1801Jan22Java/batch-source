package com.revature.dao;

import java.util.List;

import com.revature.vo.BankUserVo;

public interface BankUserDao {

	List<BankUserVo> getBankUser();				  // get list of all users' info
	BankUserVo getBankUserByName(String name);	  // get a user's info by name
	int ifUserExist(String name) ;				  // check if the user exist
	int ifRightPW (String name, String password); // check if it's right password
}
