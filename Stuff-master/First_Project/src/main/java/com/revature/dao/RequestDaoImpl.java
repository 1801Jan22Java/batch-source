package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class RequestDaoImpl {
	private static String filename = "Connection.properties";
	Employee emp = new Employee();
	private static int request_Id;
	
	public boolean createRequest(String description, double request_amount) {
		int customersAdded = 0;
		CallableStatement cs = null;
		int employee_id = emp.getEmployee_Id();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-DD");
		LocalDate date_now = LocalDate.now();
		Date current_date =Date.valueOf(date_now);
		// will have problems with the date
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			con.setAutoCommit(false);
			String sql = "{call SUBMIT_REQUEST(?,?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, employee_id);
			cs.setString(2, description);
			cs.setDouble(3, request_amount);
			cs.setDate(4, current_date);
			cs.execute();
			con.commit();
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	public String getPendingEmployeeReinbursments(int Employee_id) {
		String jsonRequests = "{\"things\":[";
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement statement = con.prepareStatement("select * from pending_request where employee_id = ?");
			statement.setInt(1, Employee_id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
			this.request_Id = rs.getInt(1);
			jsonRequests += "{\"Request_Id\":"+rs.getInt(1)+",";
			jsonRequests += "\"Employee_Id\":"+rs.getInt(2)+",";
			jsonRequests += "\"Description\":\""+rs.getString(3)+"\",";
			jsonRequests += "\"Request_Amount\":"+rs.getDouble(4)+",";
			jsonRequests += "\"Status\":"+rs.getInt(5)+",";
			jsonRequests += "\"Date_Submitted\":\""+rs.getString(6)+"\"},";

			}
			jsonRequests = jsonRequests.substring(0, jsonRequests.length()-1);
			jsonRequests+= "]}";
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonRequests;
	}
	
	public String getResolvedReinbursments(int Employee_Id) {
		String jsonRequests = "";
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement statement = con.prepareStatement("select * from pending_request where employee_id = ?");
			statement.setInt(1, Employee_Id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
			jsonRequests += "{\"Completion_Id\":"+rs.getInt(1)+",";
			jsonRequests += "\"Manager_Id\":"+rs.getInt(2)+",";
			jsonRequests += "\"Completion_Date\":\""+rs.getString(3)+"\",";
			jsonRequests += "\"Amount_Awarded\":"+rs.getDouble(4)+",";
			jsonRequests += "\"Notes\":\""+rs.getString(5)+"\"}";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonRequests;
	}
	
	public String getAllPendingEmployeeReinbursments() {
		String jsonRequests = "{\"things\":[";
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement statement = con.prepareStatement("select * from pending_request");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
			System.out.println(rs.getInt(1));
			jsonRequests += "{\"Request_Id\":"+rs.getInt(1)+",";
			jsonRequests += "\"Employee_Id\":"+rs.getInt(2)+",";
			jsonRequests += "\"Description\":\""+rs.getString(3)+"\",";
			jsonRequests += "\"Request_Amount\":"+rs.getDouble(4)+",";
			jsonRequests += "\"Status\":"+rs.getInt(5)+",";
			jsonRequests += "\"Date_Submitted\":\""+rs.getString(6)+"\"},";

			}
			
				jsonRequests = jsonRequests.substring(0, jsonRequests.length()-1);
				jsonRequests+= "]}";
				System.out.println(jsonRequests);;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonRequests;
	}
	public String getAllResolvedEmployeeReinbursments() {
		String jsonRequests = "{\"things\":[";
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement statement = con.prepareStatement("select * from completed_request");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
			System.out.println(rs.getInt(1));
			jsonRequests += "{\"Request_Id\":"+rs.getInt(1)+",";
			jsonRequests += "\"Employee_Id\":"+rs.getInt(2)+",";
			jsonRequests += "\"Description\":\""+rs.getString(3)+"\",";
			jsonRequests += "\"Request_Amount\":"+rs.getDouble(4)+",";
			jsonRequests += "\"Status\":"+rs.getInt(5)+",";
			jsonRequests += "\"Date_Submitted\":\""+rs.getString(6)+"\"},";

			}
			
				jsonRequests = jsonRequests.substring(0, jsonRequests.length()-1);
				jsonRequests+= "]}";
				System.out.println(jsonRequests);;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonRequests;
	}
}
