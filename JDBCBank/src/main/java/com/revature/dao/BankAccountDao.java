package com.revature.dao;

import java.util.List;

import com.revature.vo.BankAccountVo;

public interface BankAccountDao {

	List<BankAccountVo> getBankByUserId(int userId);
	BankAccountVo getBankAccountByAccountId(int accountId);
	void createBankAccount(int initDeposit, int userId);
	int ifBankAccountExistByUserId (int userId);
	int ifBankAccountExistById(int accountId);
	void transactMoney(String operator, int deposit, int accountId);
	void deleteBankAccountByUser(int userId);
	void deleteBankAccountByAccount(int accountId);
}
