package com.revature.dao;

import java.util.List;

import com.revature.vo.BankAccountVo;

public interface BankAccountDao {

	List<BankAccountVo> getBankByUserId(int userId);
	BankAccountVo getBankAccountByAccountId(int accountId);
	void createBankAccount(int initDeposit, int userId);
	int checkIfBankAccountExistByUserId (int userId);
	void transactMoney(String operator, int deposit, int accountId);
	void commit();
	void rollback();
}
