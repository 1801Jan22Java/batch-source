package com.revature.dao;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import com.revature.beans.Accounts;
import com.revature.beans.Transactions;
import com.revature.beans.Users;
import com.revature.util.ConnectionUtil;

public class TransactionsDaoImpl implements TransactionsDao{

	private static String filename = "connection.properties";

	//When a deposit transaction occurs it is recorded by using this
	@Override
	public void addTransaction(int userId, int accountId, float transAmnt) {

			Connection con = null;
			try {
				con = ConnectionUtil.getConnectionFromFile(filename);
				String sql = "INSERT INTO TRANSACTIONS (TRANS_ID, USER_ID, TRANS_TIME, TRANS_AMOUNT, BANK_ACCOUNT_ID, TRANS_TYPE)"
						+ "VALUES (TRANS_NUM_SEQ.NEXTVAL, ?, SYSDATE, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, userId);
				pstmt.setFloat(2, transAmnt);
				pstmt.setInt(3, accountId);
				pstmt.setInt(4, 5);
				ResultSet rs = pstmt.executeQuery();

			}catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
	}

	//When a withdraw transaction occurs it is recorded by using this
	@Override
	public void withTransaction(int userID, int accountID, float transAmount) {
		
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO TRANSACTIONS (TRANS_ID, USER_ID, TRANS_TIME, TRANS_AMOUNT, BANK_ACCOUNT_ID, TRANS_TYPE)"
					+ "VALUES (TRANS_NUM_SEQ.NEXTVAL, ?, SYSDATE, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userID);
			pstmt.setFloat(2, transAmount);
			pstmt.setInt(3, accountID);
			pstmt.setInt(4, 6);
			ResultSet rs = pstmt.executeQuery();

		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	//This returns all transactions for the user
	@Override
	public ArrayList<Transactions> getUserTransactions(int userID) {
		
		Connection con = null;
		ArrayList<Transactions> allTrans = new ArrayList<Transactions>();
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM TRANSACTIONS WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int tranID = rs.getInt("TRANS_ID");
				userID = rs.getInt("USER_ID");
				LocalDateTime tranTime = rs.getTimestamp("TRANS_TIME").toLocalDateTime();
				float tranAmnt = rs.getFloat("TRANS_AMOUNT");
				int accountID= rs.getInt("BANK_ACCOUNT_ID");
				int tranType = rs.getInt("TRANS_TYPE");
				allTrans.add(new Transactions(tranID, userID, accountID, tranTime, tranAmnt, tranType));
			}
			return allTrans;
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		return null;
	}
	
	
	
	
}
