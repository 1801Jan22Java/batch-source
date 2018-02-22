package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.CryptoType;
import com.revature.beans.Wallet;
import com.revature.util.ConnectionUtil;

public class CryptoDaoImpl implements CryptoDao{

	//Get the crypto type from the wallet by id
	@Override
	public CryptoType getCryptoType(int id) {
		CryptoType crypto = null;
		
		Connection connection;

		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_WALLET_TYPE WHERE WALLET_TYPE_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return new CryptoType(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return crypto;
	}

}
