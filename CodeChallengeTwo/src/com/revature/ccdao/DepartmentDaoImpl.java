package com.revature.ccdao;

import com.revature.ccbeans.Department;
import com.revature.ccutil.*;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class DepartmentDaoImpl implements DepartmentDao{
	public List<Department> getDepartments() {
		ArrayList<Department> departments = new ArrayList<Department>();
		
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			
		}catch(SQLException e) {
			
		}catch(IOException e) {
		
		}
		
		return departments;
	};
	public void giveRaise() {
		try(Connection conn = ConnectionUtil.getConnection("connection.properties")){
			
		}catch(SQLException e) {
			
		}catch(IOException e) {
			
		}
	};
}
