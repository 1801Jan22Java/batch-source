package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.WalmartEmployee;
import com.revature.util.ConnectionUtil;

public class WalmartEmployeeDaoImpl implements WalmartEmployeeDao{
	
	public void printDeptNameSalary () {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int departmentID;
		double salary;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")){
			ArrayList<WalmartEmployee> avgSalaryAR = new ArrayList<WalmartEmployee>();
			
			pstmt = conn.prepareStatement("SELECT * FROM WALMART_EMPLOYEE");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				salary = rs.getDouble("SALARY");
				departmentID = rs.getInt("DEPARTMENT_ID");
				
				avgSalaryAR.add(new WalmartEmployee(rs.getInt("EMPLOYEE_ID"),
													rs.getString("EMP_FIRSTNAME"),
													rs.getString("EMP_LASTNAME"),
													rs.getInt("DEPARTMENT_ID"),
													rs.getDouble("SALARY"),
													rs.getString("EMP_EMAIL")));
			}
			
			int placeholder = 0;
			WalmartEmployee temp = null;
			int currDept = 0;
			int numInDept = 0;
			double currSum = 0;
			
			ArrayList<Integer> checkedDepts = new ArrayList<Integer>();
			
			while(placeholder < avgSalaryAR.size()) {
				rs.next();
				currSum = 0;
				numInDept = 0;
				
				for(WalmartEmployee w : avgSalaryAR) {
					temp = avgSalaryAR.get(placeholder);
					if(avgSalaryAR.indexOf(temp) != avgSalaryAR.indexOf(w)) {
						continue;
					}
					
					if(checkedDepts.indexOf(w.getDepartmentID()) != -1) {
						checkedDepts.add(w.getDepartmentID());
						currSum = w.getSalary();
						numInDept++;
					}
					else if (w.getDepartmentID() == temp.getDepartmentID()){
						numInDept++;
						currSum += w.getSalary();
					}
				}
				
				if(currSum > 0) {
					pstmt = conn.prepareStatement("SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID=?");
					pstmt.setInt(1, temp.getDepartmentID());
					rs = pstmt.executeQuery();
					
					rs.next();
					System.out.println("Average salary for the " + rs.getString("DEPARTMENT_NAME") + " department is " + (currSum/numInDept));
					
				}
				
				placeholder++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void giveRaise(int deptID) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")){
			double avgSalary = 0;
			int isValid = 0;
			CallableStatement cs = null;
			String sql = "{call SP_GIVE_RAISE(?,?,?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, deptID);
			cs.setDouble(2, avgSalary);
			cs.setInt(3, isValid);
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
