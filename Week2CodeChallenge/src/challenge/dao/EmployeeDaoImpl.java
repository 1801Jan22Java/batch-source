package challenge.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import challenge.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	//file for connecting
	String filename = "connection.properties";
	
	public void giveRaise(int deptId, int percent) {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "";
			CallableStatement cs = con.prepareCall(sql);
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
