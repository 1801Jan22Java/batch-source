package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Request;
import com.revature.beans.Wallet;
import com.revature.util.ConnectionUtil;

public class WalletDaoImpl implements WalletDao{

	@Override
	public List<Wallet> getWallets(int id) {
		Connection connection;
		List<Wallet> wallets = new ArrayList<Wallet>();
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_WALLET WHERE EMP_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				wallets.add(new Wallet(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return wallets;
	}

	@Override
	public void addWallet(Wallet wallet) {

		Connection connection;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "INSERT INTO ERS_WALLET VALUES(WALLET_ID_SEQUENCE.NEXTVAL,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, wallet.getEmpID());
			statement.setString(2, wallet.getWalletName());
			statement.setString(3, wallet.getWalletAddress());
			statement.setInt(4, wallet.getWalletType());
			statement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int getWalletID(int empID, String address) {
		Connection connection;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_WALLET WHERE EMP_ID=? AND WALLET_ADDRESS=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, empID);
			statement.setString(2, address);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return -1;
	}

	@Override
	public Wallet getWalletByID(int id) {
		Wallet wallet = null;
		
		Connection connection;

		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_WALLET WHERE WALLET_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return new Wallet(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wallet;
	}

}
