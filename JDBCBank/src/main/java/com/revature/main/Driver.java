package com.revature.main;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.util.ConnectionUtil;
import com.revature.dao.*;
import com.revature.beans.*;

public class Driver {
	
	public static void main(String [] args ) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			
			System.out.println(con.getMetaData().getDriverName());
			
		}catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int i = 0;
		
		UserinfoDao ud = new UserinfoDaoSQL();
//		System.out.println( ud.addUserinfo("test user","test pass","123-45-6789","test f name", "test l name","testadr","testemail"));
		List<Userinfo> resultUserinfo = ud.getUserinfo();
		System.out.println(resultUserinfo.toString());
		
		BankuserDao bd = new BankuserDaoSQL();
		int retId = -1;
//		bd.addBankuser("hello", "pass", retId);
		List<Bankuser> resultBankuser = bd.getBankusers();
		System.out.println(resultBankuser.toString());
		
		AccountDao ad = new AccountDaoSQL();
//		ad.addAccount(1023, 0, 12.50);
		List<Account> resultAccount = ad.getAccount();
		System.out.println(resultAccount.toString());
		
		BalanceDao balanceDao = new BalanceDaoSQL();
		List<Balance> resultBalance = balanceDao.getBalances();
		System.out.println(resultBalance.toString());
		
		TransactionDao transactionDao = new TransactionDaoSQL();
//		transactionDao.addTransaction(1026, 1009, 0, 101.23);
		List<Transaction> resultTransaction = transactionDao.getTransactions();
		System.out.println(resultTransaction.toString());
		
	}

}
