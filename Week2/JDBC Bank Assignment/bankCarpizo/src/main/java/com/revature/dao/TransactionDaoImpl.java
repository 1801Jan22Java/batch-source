package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Transaction;
import com.revature.beans.TransactionType;
import com.revature.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao
{
	private static String filename = "connection.properties";

	public List<Transaction> getTransactions()
	{
		List<Transaction> transactions = new ArrayList<Transaction>();
		TransactionTypeDaoImpl transactionTypes = new TransactionTypeDaoImpl();
		BankAccountDaoImpl accounts = new BankAccountDaoImpl();
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM TRANSACTIONS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int transactionId = rs.getInt("TRANSACTION_ID");
				int accountId = rs.getInt("BANK_ACCOUNT_ID");
				LocalDate dateOfTransaction = rs.getDate("TRANSACTION_DATE").toLocalDate();
				int type = rs.getInt("TRANSACTION_TYPE_ID");
				float amount = rs.getFloat("AMOUNT");
				float balance = rs.getFloat("BALANCE");

				TransactionType transactionType = transactionTypes.getTransactionTypeById(type);
				transactions.add(new Transaction(transactionId, accounts.getBankAccountById(accountId), dateOfTransaction, transactionType, amount, balance));
			}
			con.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return transactions;
	}

	public Transaction getTransactionById(int id)
	{
		Transaction transaction = null;
		TransactionTypeDaoImpl transactionTypes = new TransactionTypeDaoImpl();
		BankAccountDaoImpl accounts = new BankAccountDaoImpl();
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM TRANSACTION WHERE TRANSACTION_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int accountId = rs.getInt("BANK_ACCOUNT_ID");
				LocalDate dateOfTransaction = rs.getDate("TRANSACTION_DATE").toLocalDate();
				int type = rs.getInt("TRANSACTION_TYPE_ID");
				float amount = rs.getFloat("AMOUNT");
				float balance = rs.getFloat("BALANCE");

				TransactionType transactionType = transactionTypes.getTransactionTypeById(type);
				transaction = new Transaction(id, accounts.getBankAccountById(accountId), dateOfTransaction, transactionType, amount, balance);
			}
			con.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return transaction;
	}

	public void createTransaction(Transaction type)
	{
		Connection con = null;
		try
		{
			con = ConnectionUtil.getConnectionFromFile(filename);
			con.setAutoCommit(false);
			String sql = "INSERT INTO TRANSACTION (BANK_ACCOUNT_ID, TRANSACTION_DATE, TRANSACTION_TYPE_ID, AMOUNT, BALANCE)"
					+" VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, type.getAccount().getId());
			pstmt.setDate(2, Date.valueOf(type.getDateOfTransaction()));
			pstmt.setInt(3, type.getType().getId());
			pstmt.setFloat(4, type.getAmount());
			pstmt.setFloat(5, type.getBalance());
			pstmt.executeUpdate();
			con.commit();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			try
			{
				con.rollback();
			} 
			catch (Exception e1)
			{
				e.printStackTrace();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		if (con != null)
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
