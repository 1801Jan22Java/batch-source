package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.Transaction;
import com.revature.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao{
	private static String filename = "connection.properties";

	@Override
	public ArrayList<Transaction> getTransactions(int accountid) {
		ArrayList<Transaction> transactions = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT t.balance, t.transactionid, t.amount, t.event_date, c.keyword, u.username " + 
					"FROM transactions t " + 
					"INNER JOIN common_lookup c ON t.transaction_type = c.common_lookup_id " + 
					"INNER JOIN users u ON t.userid = u.userid " + 
					"WHERE t.accountid = ? " +
					"ORDER BY t.event_date DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				int transactionid = rs.getInt("transactionid");
				double amount = rs.getFloat("amount");
				LocalDate eventDate = rs.getDate("event_date").toLocalDate();
				String username = rs.getString("username");
				String transactionType = rs.getString("keyword");
				double balance = rs.getFloat("balance");
				transactions.add(new Transaction(transactionid, transactionType, amount, eventDate, username, accountid, balance));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return transactions;
	}

}
