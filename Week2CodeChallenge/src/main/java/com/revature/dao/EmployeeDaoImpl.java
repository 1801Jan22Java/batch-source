package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{
	private static String filename = "connection.properties";

	@Override
	public boolean giveRaise(int deptId) {
		CallableStatement cs = null;
		int accountsUpdated = 0;
		float avgSalary = 0f;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "{ call sp_give_raise(?, ?) }";
			cs = con.prepareCall(sql);
			cs.setInt(1, deptId);
			cs.registerOutParameter(2, Types.NUMERIC);
			// Save number returned from insert statement
			accountsUpdated = cs.executeUpdate();
			avgSalary = cs.getFloat(2);
			con.close();
		} catch (SQLException e) {
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return true;
	}

}
