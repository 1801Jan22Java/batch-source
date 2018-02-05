package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import com.revature.beans.Balance;
import com.revature.util.ConnectionUtil;

public class BalanceDaoSQL implements BalanceDao {
	
	private static final String filename = "connection.properties";

	@Override
	public List<Balance> getBalances() {
		
		List<Balance> balances = new ArrayList<Balance>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return balances;
	}

	@Override
	public Balance getBalanceByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
