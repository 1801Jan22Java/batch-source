package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Bear;
import com.revature.beans.Cave;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImp;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args){
		/*Connection conn = null;
		try {
			conn = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(conn.getMetaData().getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//If we made our DAO methods static, we’d be dealing with shadowing. 
		//What if we had some sort of inherited structure. Want to use polymorphic instance methods.
		
		CaveDaoImp cd = new CaveDaoImp();
		System.out.println(cd.getCaves().toString());*/
		
		try {
			Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties");
			
			PreparedStatement pstmt = conn.prepareStatement("Select * FROM BEAR WHERE BEAR_ID=?");
			pstmt.setInt(1, 2);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("BEAR_ID");
				int typeId = rs.getInt("BEAR_TYPE_ID");
				String bearName = rs.getString("BEAR_NAME");
				String bearBirthDate = rs.getString("BEAR_BIRTHDATE");
				int bearWeight = rs.getInt("BEAR_WEIGHT");
				int caveId = rs.getInt("CAVE_ID");
				Bear b1;
				b1.add(new Bear(id, typeId, bearName, bearBirthDate, bearWeight, caveId));
			}
			
			System.out.println(pstmt);
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
