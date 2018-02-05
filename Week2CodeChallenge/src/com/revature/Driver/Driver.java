package com.revature.Driver;

import com.revature.dao.*;
import com.revature.util.ConnectionUtil;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Driver {
	
	public static void main(String[] args) {
		
		DepartmentDao dd = new DepartmentDaoSQL();
		dd.getNameAvg(1003);
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			con.setAutoCommit(false);
			String sql = "{call SP_GIVE_RAISE(?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			double new_avg = 0.0;
			int valid = 0;
			cs.setInt(1, 1003);
			cs.setDouble(2,new_avg);
			cs.setInt(3, valid);
			
			cs.execute();
			System.out.println("did the thing");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		dd.getNameAvg(1003);
		
	}

}
