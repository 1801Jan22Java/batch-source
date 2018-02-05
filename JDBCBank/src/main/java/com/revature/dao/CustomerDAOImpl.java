package com.revature.dao;

import java.io.IOException;
import java.sql.*;

import com.revature.beans.*;
import com.revature.util.ConnectionUtil;

public class CustomerDAOImpl implements CustomerDAO {
	
	@Override
	public boolean getCustByUsername(String username, String password) {
		PreparedStatement pstmt = null;
		CustomerDAOImpl customerDao = new CustomerDAOImpl();
		Customer currentCustomer = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
//			String sql = "SELECT * FROM CUSTOMER WHERE USER_ID = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, id);
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				String name = rs.getString("BEAR_NAME");
//				int weight = rs.getInt("BEAR_WEIGHT");
//				int caveId = rs.getInt("CAVE_ID");
//				Account account = cdi.getCaveById(caveId);
//				int typeId = rs.getInt("BEAR_TYPE_ID");
//				BearType bt = btdi.getBearTypeById(typeId);
//				LocalDate birthdate = rs.getDate("BEAR_BIRTHDATE").toLocalDate();
//				bear = new Bear(id, name, cave, bt, weight, birthdate);
//			}
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		return true;
	}

}
