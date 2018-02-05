package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exception.NotEnoughBalanceException;
import com.revature.util.ConnectionUtil;
import com.revature.vo.BankAccountVo;

public class BankAccountDaoImpl implements BankAccountDao {
	
	private static String filename = "connection.properties";
	
	@Override
	public List<BankAccountVo> getBankByUserId(int userId) {
		String sql = "SELECT * FROM BANKACCOUNT WHERE USER_ID = ? ORDER BY ID";
		PreparedStatement pstmt = null;
		
		List<BankAccountVo> accountVoList = new ArrayList<BankAccountVo>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, userId);
				
				ResultSet rs = pstmt.executeQuery();
				int id, balance;
				
				while (rs.next()) {
					id = rs.getInt("ID");
					balance = rs.getInt("BALANCE");
					accountVoList.add(new BankAccountVo(id, userId, balance));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		return accountVoList;
	}
	
	@Override
	public BankAccountVo getBankAccountByAccountId(int accountId) {
		BankAccountVo accountVo = null;

		String sql = "SELECT * FROM BANKACCOUNT WHERE ID = ?";
		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, accountId);
				
				ResultSet rs = pstmt.executeQuery();
				int userId, balance;
				
				while (rs.next()) {
					userId = rs.getInt("USER_ID");
					balance = rs.getInt("BALANCE");
					accountVo = new BankAccountVo(accountId, userId, balance);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		return accountVo;
	}
	
	@Override
	public void createBankAccount(int initDeposit, int userId) {
		
		String sql = "INSERT INTO BANKACCOUNT (ID, USER_ID, BALANCE) "
				+ " VALUES (BANKACCOUNT_SEQ.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			con.setAutoCommit(false); 
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, userId);
			pstmt.setInt(2, initDeposit);
			
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int checkIfBankAccountExistByUserId(int userId) {
		
		String sql = "SELECT COUNT(*) AS CNT FROM BANKACCOUNT WHERE USER_ID = ?";
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					cnt = rs.getInt("CNT"); // if cnt is 0, not-exist
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		return cnt;
	}
	
	@Override
	public void transactMoney(String operator, int deposit, int accountId) {
		String sql = "UPDATE BANKACCOUNT SET BALANCE = BALANCE "
				+ operator + " ? WHERE ID = ?";
		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			if (operator.equals("-")) {
				int balance = getBankAccountByAccountId(accountId).getBalance();
				if (balance < deposit) {
					throw new NotEnoughBalanceException();
				}
			}
			
			// con.setAutoCommit(false); 		doesn't work.. still commited automatically.
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, deposit);
			pstmt.setInt(2, accountId);
			
			pstmt.executeUpdate();
			pstmt.close();
			// con.setAutoCommit(true); 
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotEnoughBalanceException e) {
		} 
	}
	
	
	
	@Override
	public void commit() {
		 
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			con.setAutoCommit(false); 
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void rollback() {
		 
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			con.setAutoCommit(false); 
			con.rollback();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
