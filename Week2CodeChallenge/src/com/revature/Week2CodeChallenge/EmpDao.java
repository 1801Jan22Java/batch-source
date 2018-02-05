package com.revature.Week2CodeChallenge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface EmpDao {
	public static void getAvgSalary (Connection con) throws Exception {
		String sql = "Select B.DEPARTMENT_NAME, AVG(A.SALARY) AS AVG FROM A EMLPOYEE INNER JOIN B DEPARTMENT ON A.DEPARTMENT_ID = B.DEPARTMENT_ID";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			System.out.println(rs.getString("DEPARTMENT_NAME"));
			System.out.println(rs.getDouble("AVG"));
		}
	}
}
