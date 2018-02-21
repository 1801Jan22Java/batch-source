package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BearType;
import com.revature.util.ConnectionUtil;

public class BearTypeDaoImpl implements BearTypeDao {
	
	
	@Override
	public List<BearType> getBearTypes() {
		List<BearType> btl = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			//use a Statement - remember the danger of SQL injection 
			String sql = "SELECT * FROM BEAR_TYPE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("BEAR_TYPE_ID");
				String name = rs.getString("BEAR_TYPE_NAME");
				BearType newBT = new BearType(id,name);
				btl.add(newBT);
			}
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return btl;
	}

	@Override
	public BearType getBearTypeById(int id) {
		PreparedStatement pstmt = null;
		BearType bt = null; 
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM BEAR_TYPE WHERE BEAR_TYPE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name  = rs.getString("BEAR_TYPE_NAME");
				bt = new BearType(id,name);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bt;
	}

}
