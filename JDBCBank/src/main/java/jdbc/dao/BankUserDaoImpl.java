package jdbc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.beans.BankUser;
import jdbc.util.ConnectionUtil;

public class BankUserDaoImpl implements BankUserDao{

	String filename = "connection.properties";
	
	public void addNewUser(String username, String password) {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "INSERT INTO BANK_USER (USERNAME, PASSWORD, IS_SUPER) VALUES(?,?, 0)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.execute();
			System.out.println("welcome new user "+username);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUsername(String newName, int userId) {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE BANK_USER SET USERNAME = ? WHERE USERID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newName);
			pstmt.setInt(2, userId);
			pstmt.execute();
			System.out.println("username successfully updated");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePassword(String newPass, int userId) {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE BANK_USER SET PASSWORD = ? WHERE USERID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPass);
			pstmt.setInt(2, userId);
			pstmt.execute();
			System.out.println("password successfully updated");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "DELETE FROM BANK_USER WHERE USERID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.execute();
			System.out.println("user successfully deleted");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isSuper(String username, String password) {
		boolean bool = false;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT IS_SUPER FROM BANK_USER WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int i = rs.getInt("IS_SUPER");
				if(i==0) {
					return false;
				}
				else {
					return true;
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bool;
	}
	
	public int getIdByUserAndPass(String username, String password) {
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT USERID FROM BANK_USER WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int i = rs.getInt("USERID");
				return i;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<BankUser> viewUser(int userId) {
		
		List<BankUser> b = new ArrayList<BankUser>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANK_USER WHERE USERID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("USERID");
				int j = rs.getInt("ACCOUNTID");
				String s1 = rs.getString("USERNAME");
				String s2 = rs.getString("PASSWORD");
				int k = rs.getInt("IS_SUPER");
				boolean bool;
				if(k==0) {
					bool=false;
				}
				else {
					bool=true;
				}
				b.add(new BankUser(i, j, s1, s2, bool));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
		
	}
}
