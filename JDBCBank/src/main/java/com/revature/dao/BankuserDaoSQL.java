package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.beans.Balance;
import com.revature.beans.Bankuser;
import com.revature.util.ConnectionUtil;

public class BankuserDaoSQL implements BankuserDao {

	@Override
	public List<Bankuser> getBankusers() {
		
		List<Bankuser> resultBankuser = new ArrayList<Bankuser>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			Bankuser result;
			String sql = "SELECT * FROM BANKUSER";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("BANKUSERID");
				String user = rs.getString("BANKUSER");
				String pass = rs.getString("PASSWORD");
				result = new Bankuser(id,user,pass);
				resultBankuser.add(result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return resultBankuser;
	}

	@Override
	public Bankuser getBankuserByID(int id) {
		Bankuser result = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANKUSER WHERE BANKUSERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int bnkId = rs.getInt("BANKUSERID");
				String user = rs.getString("BANKUSER");
				String pass = rs.getString("PASSWORD");
				result = new Bankuser(bnkId,user,pass);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public int addBankuser(String username, String password) {
		
		int id = -1;

		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "call NEW_BANKUSER(?,?,?)";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, password);
			cs.registerOutParameter(3,java.sql.Types.INTEGER);
			cs.execute();
			
			id = cs.getInt(3);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;
		
	}
	
}
