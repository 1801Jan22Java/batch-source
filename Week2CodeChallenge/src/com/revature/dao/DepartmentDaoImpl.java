package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.revature.beans.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao{

	/* (non-Javadoc)
	 * @see com.revature.dao.DepartmentDao#getDepartments()
	 */
	@Override
	public List<Department> getDepartments() {
		List<Department> dept = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM DEPARTMENT";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("DEPARTMENT_ID");
				String type = rs.getString("DEPARTMENT_NAME");
				dept.add(new Department(id, type));
			}
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return dept;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.DepartmentDao#getDepartmentByID(int)
	 */
	@Override
	public Department getDepartmentByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
