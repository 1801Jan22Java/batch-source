package challenge.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import challenge.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao{
	
	//file for connecting
	String filename = "connection.properties";
	
	public void printAllDeptNameAndSalary() {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT DISTINCT DEPARTMENT_NAME, AVG(SALARY) FROM DEPARTMENT D, EMPLOYEE E " + 
					"WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID " + 
					"GROUP BY DEPARTMENT_NAME";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String dName = rs.getString("DEPARTMENT_NAME");
				int avgSal = rs.getInt("AVG(SALARY)");
				System.out.println(dName+ "has an average salary of "+avgSal);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
