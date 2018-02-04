package com.revature.dao;

import java.io.IOException; 
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.Transaction;
import com.revature.util.ConnectionUtil;
import com.revature.util.InvalidTransactionIdException;

public class TransactionDaoImpl implements TransactionDao {

	public static final String filename = "connection.properties";
	
	public ArrayList<Transaction> getTransactions(Account a) {
		ArrayList<Transaction> monies = null;
		
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			monies = new ArrayList<Transaction>();
			int account = a.getAccountID();
			int valid = 0;
			int id = 0;
			Double amount = 0.0;
			LocalDate when = null;
			String sql = "SELECT * FROM TRANSACTIONS WHERE ACCOUNTID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, account);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				valid = rs.getInt(5);
				if(valid > 0) {
					// within the database, a value of 0 will mark a 'dead' transaction, one 
					// whose account was deleted. The actual data is not removed
					// for archival purposes
					id = rs.getInt(1);
					amount = rs.getDouble(3);
					when = rs.getDate(4).toLocalDate();
					monies.add(new Transaction(when, id, amount));
				}
			}
			con.close();
		} catch (SQLException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return monies;
	}

	public Transaction getTransactionByID(int id) throws InvalidTransactionIdException{
		Transaction t = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			int valid = 0;
			int transID = id;
			Double amount = 0.0;
			LocalDate when = null;
			String sql = "SELECT * FROM TRANSACTIONS WHERE TRANSACTIONID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, transID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			// if not while, because the transactionID is the primary key 
			// and thus is unique 
				valid = rs.getInt(5);
				if(valid > 0) {
					// within the database, a value of 0 will mark a 'dead' transaction, one 
					// whose account was deleted. The actual data is not removed
					// for archival purposes
					transID = rs.getInt(1);
					amount = rs.getDouble(3);
					when = rs.getDate(4).toLocalDate();
					return new Transaction(when, transID, amount);
				}
				else {
					con.close();
					throw new InvalidTransactionIdException("Transaction does not exist!");
				}
				
			}
			else {
				con.close();
				throw new InvalidTransactionIdException("Transaction does not exist!");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	public void addTransaction(Transaction t, Account a) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			int aid = a.getAccountID();
			int tid = t.getTransactionID();
			Double amount = t.getAmount();
			int active = 1;

			String sql = "{call initialize_transaction(?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, tid);
			cs.setInt(2, aid);
			cs.setDouble(3, amount);
			cs.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
			cs.setDouble(5, active);

			if (cs.executeUpdate() > 1) {
				System.out.println("More than 1 row updated");
			}
			
			a.setBalance(a.getBalance() - amount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getNextTransactionID() {
		int tid = 0;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT PK_TRANSACTION.NEXTVAL FROM DUAL";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				tid = rs.getInt(1);

			else
				throw new RuntimeException("No next value in sequence");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tid;
	}

	public void deleteTransaction(Transaction t) {
		// TODO Auto-generated method stub

	}

}
