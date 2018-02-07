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
			int valid = -1;
			cs.setInt(1, 1003);
			cs.registerOutParameter(2, java.sql.Types.DOUBLE);
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			cs.execute();
			valid = cs.getInt(3);
			if (valid == 0) {
				System.out.println("Callable statement was successful");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		dd.getNameAvg(1003);
		
	}

}
