package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.beans.Userinfo;
import com.revature.util.ConnectionUtil;

public class UserinfoDaoSQL implements UserinfoDao {

	@Override
	public List<Userinfo> getUserinfo() {
		
		List<Userinfo> resultUserinfo = new ArrayList<Userinfo>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			Userinfo result;
			String sql = "SELECT * FROM USERINFO";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int usrId = rs.getInt("USERINFOID");
				int bnkId = rs.getInt("BANKUSERID");
				String ssn = rs.getString("SSN");
				String fname = rs.getString("FIRSTNAME");
				String lname = rs.getString("LASTNAME");
				String addr = rs.getString("ADDRESS");
				String email = rs.getString("EMAIL");
				result = new Userinfo(usrId,bnkId,ssn,fname,lname,addr,email);
				resultUserinfo.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultUserinfo;
	}

	@Override
	public Userinfo getUserinfoByID(int id) {
		Userinfo result = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM USERINFO WHERE USERINFOID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int usrId = rs.getInt("USERINFOID");
				int bnkId = rs.getInt("BANKUSERID");
				String ssn = rs.getString("SSN");
				String fname = rs.getString("FIRSTNAME");
				String lname = rs.getString("LASTNAME");
				String addr = rs.getString("ADDRESS");
				String email = rs.getString("EMAIL");
				result = new Userinfo(usrId,bnkId,ssn,fname,lname,addr,email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int addUserinfo(String usr, String pass, String ssn, String fname, String lname, String address, String email) {
		
		int id = -1;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call NEW_USERINFO(?,?,?,?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, usr);
			cs.setString(2, pass);
			cs.setString(3, ssn);
			cs.setString(4, fname);
			cs.setString(5, lname);
			cs.setString(6, address);
			cs.setString(7,email);
			cs.registerOutParameter(8,java.sql.Types.INTEGER);
			
			cs.execute();
			
			id = cs.getInt(8);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
		return id;
	}

}
