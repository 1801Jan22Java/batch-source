package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.exception.NotExistUserException;
import com.revature.exception.WrongPassworException;
import com.revature.util.ConnectionUtil;
import com.revature.vo.BankUserVo;

public class BankUserDaoImpl implements BankUserDao {

	private static String filename = "connection.properties";

	@Override
	public List<BankUserVo> getBankUser() {
		List<BankUserVo> bankUsers = new ArrayList<BankUserVo>();
				
		String sql = "SELECT * FROM BANKUSER";

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					int id = rs.getInt("ID");
					String name = rs.getString("NAME");
					String pw = rs.getString("PW");
					int lv = rs.getInt("LV");
					bankUsers.add(new BankUserVo(id,name,pw,lv));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return bankUsers;
	}
	
	
	@Override
	public BankUserVo getBankUserByName(String name) {
		BankUserVo userVo = new BankUserVo();
		
		String sql = "SELECT * FROM BANKUSER WHERE NAME = ?";
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userVo.setId(rs.getInt("ID"));
				userVo.setName(rs.getString("NAME"));
				userVo.setPw(rs.getString("PW"));
				userVo.setLv(rs.getInt("LV"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userVo;
	}
	
	@Override
	public int ifUserExist(String name) {
		
		String sql = "SELECT COUNT(*) AS CNT FROM BANKUSER WHERE NAME = ?";
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					cnt = rs.getInt("CNT"); // if cnt is 0, not-exist
				}
				if (cnt < 1) {
					throw new NotExistUserException();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NotExistUserException e) {
				
			} 
		return cnt;
	}
	
	@Override
	public int ifRightPW(String name, String password) {
		String sql = "SELECT CASE WHEN PW = ? THEN 1 ELSE 0 END AS IFRIGHTPW"
				+ " FROM BANKUSER WHERE NAME = ?";
		PreparedStatement pstmt = null;
		
		int ifRightPW = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, password);
				pstmt.setString(2, name);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					ifRightPW = rs.getInt("IFRIGHTPW"); // if cnt is 0, not-exist
				}
				if (ifRightPW < 1) {
					throw new WrongPassworException();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WrongPassworException e) {
				
			} 
		return ifRightPW;
	}
}
