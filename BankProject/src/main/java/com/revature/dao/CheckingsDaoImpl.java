package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Checkings;
import com.revature.util.ConnectionUtil;

public class CheckingsDaoImpl implements CheckingsDao {

	private static String filename = "connection.properties";
	
	@Override
	public Checkings getCheckingsByUserId(int userId) {

		PreparedStatement pstmt = null;

		Checkings checkings = null; 

		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			String sql = "SELECT CHECKINGS_BALANCE FROM CHECKINGS WHERE USER_ID = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,userId);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()){

				double checkingsBalance  = rs.getDouble("CHECKINGS_BALANCE");
				checkings = new Checkings(checkingsBalance);
			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return checkings;
	}

	@Override
	public void updateCheckingsBalance(int userId, double checkingsBalance) {
		PreparedStatement pstmt = null;

		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			String sql = "UPDATE CHECKINGS SET CHECKINGS_BALANCE = ? WHERE USER_ID = ?;";

			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, checkingsBalance);
			pstmt.setInt(2, userId);

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
