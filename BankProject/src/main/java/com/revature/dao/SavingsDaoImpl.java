package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Savings;
import com.revature.util.ConnectionUtil;

public class SavingsDaoImpl implements SavingsDao {

	private static String filename = "connection.properties";
	
	@Override
	public Savings getSavingsByUserId(int userId) {
		PreparedStatement pstmt = null;

		Savings savings = null; 

		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			String sql = "SELECT SAVINGS_BALANCE FROM SAVINGS WHERE USER_ID = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,userId);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()){

				double savingsBalance  = rs.getDouble("SAVINGS_BALANCE");
				savings = new Savings(savingsBalance);
			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return savings;
	}

	@Override
	public void updateSavingsBalance(int userId, double savingsBalance) {
		PreparedStatement pstmt = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			String sql = "UPDATE CHECKINGS SET SAVINGS_BALANCE = ? WHERE USER_ID = ?;";

			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, savingsBalance);
			pstmt.setInt(2, userId);

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
