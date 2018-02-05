package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeesDao {

	public static String filename = "Connection.properties";
	@Override
	public void get_Name_Salary() {
		int average_1 = 0;
		int average_2 = 0;
		int average_3 = 0;
		int count_1 = 0;
		int count_2 = 0;
		int count_3 = 0;
		String dpt_1 = null,dpt_2 = null,dpt_3 = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement ps = con.prepareStatement("select * from employee");
			//ps.setInt(1, departmentid);
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps2 = con.prepareStatement("select * from department");
			
			while(rs.next()) {
				if(rs.getInt(4) == 1) {
					average_1 += rs.getInt(5);
					count_1+= 1;
				}
				else if(rs.getInt(4) == 2) {
					average_2 += rs.getInt(5);
					count_2+= 1;
				}
				else if(rs.getInt(4) == 3) {
					average_3 += rs.getInt(5);
					count_3+= 1;
				}
				
			}
			
			ResultSet rs2 = ps2.executeQuery();
			while(rs.next()) {
				if(rs2.getInt(1) == 1) {
					dpt_1 = rs2.getString(2);
				}
				else if(rs2.getInt(1) == 2) {
					dpt_2 = rs2.getString(2);
				}
				else if(rs2.getInt(1) == 3) {
					dpt_3 = rs2.getString(2);
				}
			}
			
			System.out.println(dpt_1 + " " + average_1 );
			System.out.println(dpt_2 + " " + average_2 );
			System.out.println(dpt_3 + " " + average_3 );
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void give_Raise(int department_Num) {
		CallableStatement cs = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			con.setAutoCommit(false);
			String sql = "{call SP_GIVE_RAISE(" +department_Num+")}";
			cs = con.prepareCall(sql);
			cs.execute();
			System.out.println("Gave Raise");
			
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
