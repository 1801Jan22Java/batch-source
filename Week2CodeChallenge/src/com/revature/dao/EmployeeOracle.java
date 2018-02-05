package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class EmployeeOracle implements EmployeeDao {

	private String filename = "connection.properties";

	public void giveRaise(int depId) {
		String sql = "{call SP_GIVE_RAISE(?, ?, ?) } ";
		CallableStatement cs = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			cs = con.prepareCall(sql);
			cs.setInt(1, depId);
			cs.registerOutParameter(2, java.sql.Types.NUMERIC);
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			cs.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
