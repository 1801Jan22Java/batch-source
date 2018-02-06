package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import com.revature.beans.Balance;
import com.revature.util.ConnectionUtil;

public class BalanceDaoSQL implements BalanceDao {

	@Override
	public List<Balance> getBalances() {
		
		List<Balance> resultBalance = new ArrayList<Balance>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			Balance result;
			String sql = "SELECT * FROM BALANCE";
			PreparedStatement ps = con.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int balId = rs.getInt("BALANCEID");
				double initBalance = rs.getDouble("INITIALBALANCE");
				result = new Balance(balId,initBalance);
				resultBalance.add(result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return resultBalance;
	}

	@Override
	public Balance getBalanceByID(int id) {
		Balance result = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "SELECT * FROM BALANCE WHERE BALANCEID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int balId = rs.getInt("BALANCEID");
				double initBalance = rs.getDouble("INITIALBALANCE");
				result = new Balance(balId,initBalance);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public int addBalance(double initBalance) {
		int id = -1;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call NEW_BALANCE(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setDouble(1, initBalance);
			cs.registerOutParameter(2,java.sql.Types.INTEGER);
			cs.execute();
			id = cs.getInt(2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return id;
	}

	@Override
	public void updateBalance(int balId, double afterBalance) {
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE BALANCE SET INITIALBALANCE = ? WHERE BALANCEID = ? ";
			PreparedStatement ps = con.prepareCall(sql);
			ps.setDouble(1, afterBalance);
			ps.setInt(2, balId);
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

	
}
