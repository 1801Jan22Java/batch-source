package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public List<Transaction> getAccountTransactions(Account account) {
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		try {
			System.out.println("Account transactions:");
			
			String sql = "SELECT * FROM BANK_TRANSACTIONS WHERE ACCOUNTID=?";
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			statement.setInt(1, account.getAccountID());
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int tid = rs.getInt(1);
				int uid = rs.getInt(2);
				int aid = rs.getInt(3);
				float oldBal = rs.getFloat(4);
				float newBal = rs.getFloat(5);
				Timestamp time = rs.getTimestamp(6);
				
				Transaction transaction = new Transaction(tid, uid, aid, oldBal, newBal, time);
				System.out.println(transaction.toString());
				transactions.add(transaction);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transactions;
	}

}
