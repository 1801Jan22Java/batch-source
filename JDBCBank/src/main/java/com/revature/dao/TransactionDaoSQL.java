package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Transaction;
import com.revature.util.ConnectionUtil;

public class TransactionDaoSQL implements TransactionDao {

	@Override
	public List<Transaction> getTransactions() {
		List<Transaction> resultTransaction = new ArrayList<Transaction>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			Transaction result;
			String sql = "SELECT * FROM TRANSACTION";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int trnId = rs.getInt("TRANSACTIONID");
				int balId = rs.getInt("BALANCEID");
				int accId = rs.getInt("ACCOUNTID");
				int type  = rs.getInt("TYPE");
				double trnAmount = rs.getInt("TRANSACTIONAMOUNT");
				result = new Transaction(trnId,balId,accId,type,trnAmount);
				resultTransaction.add(result);
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return resultTransaction;
	}

	@Override
	public Transaction getTransactionByID(int id) {
		Transaction result = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "SELECT * FROM TRANSACTION WHERE ACCOUNTID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int trnId = rs.getInt("TRANSACTIONID");
				int balId = rs.getInt("BALANCEID");
				int accId = rs.getInt("ACCOUNTID");
				int type  = rs.getInt("TYPE");
				double trnAmount = rs.getInt("TRANSACTIONAMOUNT");
				result = new Transaction(trnId,balId,accId,type,trnAmount);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int addTransaction(int balanceId, int accountId, int type, double transactionAmount) {
		int id = -1;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call NEW_TRANSACTION(?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, balanceId);
			cs.setInt(2,accountId);
			cs.setInt(3,type);
			cs.setDouble(4, transactionAmount);
			cs.registerOutParameter(5,java.sql.Types.INTEGER);
			cs.execute();
			
			id = cs.getInt(5);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return id;
		
	}

}
