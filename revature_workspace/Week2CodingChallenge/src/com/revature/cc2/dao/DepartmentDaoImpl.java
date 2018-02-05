package com.revature.cc2.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.cc2.beans.Department;
import com.revature.cc2.util.ConnectionUtil;


public class DepartmentDaoImpl implements DepartmentDao {
	private static String filename = "connection.properties";

	@Override
	public Department getDepartmentByID(int id) {
		Department department=null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{

			PreparedStatement prepStmt = 
					con.prepareStatement("SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID="+id);
			prepStmt.execute();
			ResultSet rs= prepStmt.getResultSet();
			if(rs.next())
			{
				String name=rs.getString("DEPARTMENT_NAME");
			

				department=new Department(name);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return department;
		}
	}

	@Override
	public float getAverageSalary(int id) {
		float avgSalary = 0.0f;
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			
			conn.setAutoCommit(false);
			System.out.println("In try statement");
			String sqlStmt="{CALL SP_GIVE_RAISE(?,?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setInt(1,id);
			cs.registerOutParameter(2, java.sql.Types.FLOAT);
		
			cs.execute();
			conn.commit();
			avgSalary=cs.getFloat(2);
		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}
		finally{
		System.out.println(avgSalary);
		return avgSalary;
		}
	}
	public float getPreviousAverageSalary(int id) {
		float avgSalary = 0.0f;
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			
			conn.setAutoCommit(false);
			System.out.println("In try statement");
			String sqlStmt="SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPARTMENT_ID =?";
			PreparedStatement cs = conn.prepareCall(sqlStmt);
			cs.setInt(1,id);
			cs.execute();
			ResultSet rs= cs.getResultSet();
			while(rs.next()){
				avgSalary=rs.getFloat(1);
			}
		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}
		finally{
		System.out.println(avgSalary);
		return avgSalary;
		}
	}

}
