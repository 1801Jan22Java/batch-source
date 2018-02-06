package com.revature.bdao;

import java.util.List;

import com.revature.bbeans.Transaction;

public interface ITransactionDAO {
	public List<Transaction> viewTransactionHistory();
}
