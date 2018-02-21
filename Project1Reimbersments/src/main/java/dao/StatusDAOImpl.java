package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Document;
import beans.Status;
import util.ConnectionUtil;

public class StatusDAOImpl implements StatusDAO
{
	private static String filename = "Properties";
	@Override
	public ArrayList<Status> getStatuses() {
		ArrayList<Status> stats = new ArrayList<Status>();
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "SELECT * FROM STATUS";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(stmt);
			
			while (rs.next())
			{
				int statId = rs.getInt("STATUS_ID");
				String name = rs.getString("STAUS_NAME");
				Status s = new Status(name, statId);
				stats.add(s);
			}	
			return stats;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return stats;
	}

	@Override
	public ArrayList<Integer> getStatusIds() {
		ArrayList<Integer> statIds = new ArrayList<Integer>();
		for(Status s: this.getStatuses())
		{
			statIds.add(new Integer(s.getStatusId()));
		}
		return statIds;
	}

	@Override
	public String getStatusName(int id) {
		for(Status s: this.getStatuses())
		{
			if(s.getStatusId()==id)
			{
				return s.getName();
			}
		}
		return null;
	}

	@Override
	public Integer getStatusId(String name) {
		for(Status s: this.getStatuses())
		{
			if(s.getName().equals(name))
			{
				return s.getStatusId();
			}
		}
		return null;
	}

	@Override
	public boolean creatStatus(String name, int statusId) {
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			String sql = "INSERT INTO STATUS(STATUS_NAME, STATUD_ID) VALUES(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, statusId);
			return pstmt.execute();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e2) 
		{
			e2.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		StatusDAOImpl statDao = new StatusDAOImpl();
		System.out.println(statDao.getStatuses());
	}
}
