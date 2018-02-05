package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.util.ConnectionUtil;
import com.revature.vo.DepartmentsVo;

public class MainDaoImpl implements MainDao {

	private static String filename = "connection.properties";

	@Override
	public List<DepartmentsVo> getDepartmentsList() {
		// TODO Auto-generated method stub
		List<DepartmentsVo> deptsVos = new ArrayList<DepartmentsVo>();
		
		String sql = 	"SELECT D.DEPARTMENT_ID AS ID, D.DEPARTMENT_NAME AS NAME, AVG(E.SALARY) AS AVGSALARY \r\n" + 
				"FROM DEPARTMENTS D, EMPLOYEES E\r\n" + 
				"WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID\r\n" + 
				"GROUP BY D.DEPARTMENT_NAME, D.DEPARTMENT_ID";
		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int avgSalary = rs.getInt("AVGSALARY");
				
				deptsVos.add(new DepartmentsVo(id,name,avgSalary));
			}
			pstmt.close();
			con.close();
		} catch (SQLException | IOException e) {
			// TODO: handle exception
		}
		return deptsVos;
	}

	@Override
	public void callStoredProcedure(int department_id) {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			 CallableStatement cs = con.prepareCall("{call SP_GIVE_RAISE(?,?,?)}");
			 
			 cs.setInt(1, department_id);
			 cs.registerOutParameter(2,Types.NUMERIC);
		     cs.registerOutParameter(3,Types.BOOLEAN);
		     cs.execute();
		     int avgSalary = cs.getInt(2);
			 boolean ifValidDeptId = cs.getBoolean(3);
			 
			 System.out.println(avgSalary + "/" + ifValidDeptId);
			 con.close();
			con.prepareCall("{call javatest(?,?,?)}");
		} catch (SQLException | IOException e) {
		}
	}
	
	 
}
