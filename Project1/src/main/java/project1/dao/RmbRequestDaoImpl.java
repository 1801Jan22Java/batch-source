package project1.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project1.beans.RmbRequest;
import project1.util.ConnectionUtil;

public class RmbRequestDaoImpl implements RmbRequestDao{
	
	public void submitRequest(int empId, String image) {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "INSERT INTO RMB_REQUEST(EMP_ID, STATUS, IMAGE) VALUES(?,0,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			pstmt.setString(2, image);
			pstmt.execute();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	public List<RmbRequest> viewPendingByEmpId(int empId){
		List<RmbRequest> pending = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM RMB_REQUEST WHERE EMP_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int i = rs.getInt("REQUEST_ID");
				int j = rs.getInt("EMP_ID");
				int status = rs.getInt("STATUS");
				String image = rs.getString("IMAGE");
				String manager = rs.getString("MANAGER");
				if(status==0) {
					pending.add(new RmbRequest(i,j,status,image,manager));
				}
			}
			
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return pending;
	}
	
	public List<RmbRequest> viewResolvedByEmpId(int empId){
		List<RmbRequest> resolved = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM RMB_REQUEST WHERE EMP_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int i = rs.getInt("REQUEST_ID");
				int j = rs.getInt("EMP_ID");
				int status = rs.getInt("STATUS");
				String image = rs.getString("IMAGE");
				String manager = rs.getString("MANAGER");
				if(status==1||status==2) {
					resolved.add(new RmbRequest(i,j,status,image,manager));
				}
			}
			
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return resolved;
	}
	
	public List<RmbRequest> viewAllPending(){
		List<RmbRequest> pending = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM RMB_REQUEST WHERE STATUS = 0";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int i = rs.getInt("REQUEST_ID");
				int j = rs.getInt("EMP_ID");
				int status = rs.getInt("STATUS");
				String image = rs.getString("IMAGE");
				String manager = rs.getString("MANAGER");
				pending.add(new RmbRequest(i,j,status,image,manager));
			}
			
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return pending;
	}
	
	public List<RmbRequest> viewAllResolved(){
		List<RmbRequest> resolved = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM RMB_REQUEST WHERE STATUS = 1 OR STATUS = 2";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int i = rs.getInt("REQUEST_ID");
				int j = rs.getInt("EMP_ID");
				int status = rs.getInt("STATUS");
				String image = rs.getString("IMAGE");
				String manager = rs.getString("MANAGER");
				resolved.add(new RmbRequest(i,j,status,image,manager));
			}
			
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return resolved;
	}
	
	public List<RmbRequest> viewRequestsByEmpId(int empId){
		List<RmbRequest> requests = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM RMB_REQUEST WHERE EMP_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int i = rs.getInt("REQUEST_ID");
				int j = rs.getInt("EMP_ID");
				int status = rs.getInt("STATUS");
				String image = rs.getString("IMAGE");
				String manager = rs.getString("MANAGER");
				requests.add(new RmbRequest(i,j,status,image,manager));
			}
			
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return requests;
	}
	
	public void approveDenyRequest(int reqId, int status, String managerName) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "UPDATE RMB_REQUEST SET STATUS = ?, MANAGER = ? WHERE REQUEST_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, status);
			pstmt.setString(2, managerName);
			pstmt.setInt(3, reqId);
			pstmt.execute();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}

}
