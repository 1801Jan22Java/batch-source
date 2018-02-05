package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.beans.Accounts;
import com.revature.util.ConnectionUtil;

public class AccountsDaoImpl implements AccountsDao {
	public static String filename = "Connection.properties";
	SecurityDaoImpl security = new SecurityDaoImpl();

	@Override
	public List<Accounts> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFunds(double money) {
		double funds;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			PreparedStatement statement = con.prepareStatement("select savings from accounts where userid = ? ");
			statement.setInt(1, security.getUserID());
			ResultSet rs = statement.executeQuery();
			rs.next();
			System.out.println(rs.getDouble(1));
			funds = rs.getDouble(1) + money;
			PreparedStatement statement2 = con.prepareStatement("update accounts set savings = ? where userid = ? ");
			statement2.setDouble(1, funds);
			statement2.setInt(2, security.getUserID());
			statement2.executeUpdate();

			System.out.println("Your new balance is: $" + funds);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void removeFunds(double money) {
		double funds;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			PreparedStatement statement = con.prepareStatement("select savings from accounts where userid = ? ");
			statement.setInt(1, security.getUserID());
			ResultSet rs = statement.executeQuery();
			rs.next();
			if (rs.getDouble(1) - money <= 0) {
				System.out.println("You do not have enough money to withdraw that amount");
			} else {
				System.out.println(rs.getDouble(1));
				funds = rs.getDouble(1) - money;
				PreparedStatement statement2 = con
						.prepareStatement("update accounts set savings = ? where userid = ? ");
				statement2.setDouble(1, funds);
				statement2.setInt(2, security.getUserID());
				statement2.executeUpdate();

				System.out.println("Your new balance is: $" + funds);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public double getBalance() {
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement stmt = con.prepareStatement("Select savings from accounts where userid = ? ");
			stmt.setInt(1, security.getUserID());
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			return rs.getDouble(1);
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void deleteAccount(int account) {
		int customersAdded = 0;
		CallableStatement cs = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			con.setAutoCommit(false);
			String sql = "{call DELETE_ACCOUNT("+ account+")}";
			cs = con.prepareCall(sql);
			cs.execute();
			con.commit();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

	@Override
	public double getBalance_Super(int account) {
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement stmt = con.prepareStatement("Select savings from accounts where userid = ? ");
			stmt.setInt(1, account);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			return rs.getDouble(1);
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void addFunds_Super(int account, double money) {
		double funds;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			PreparedStatement statement = con.prepareStatement("select savings from accounts where userid = ? ");
			statement.setInt(1, account);
			ResultSet rs = statement.executeQuery();
			rs.next();
			funds = rs.getDouble(1) + money;
			PreparedStatement statement2 = con.prepareStatement("update accounts set savings = ? where userid = ? ");
			statement2.setDouble(1, funds);
			statement2.setInt(2, account);
			statement2.executeUpdate();

			System.out.println("The new balance is: $" + funds);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeFunds_Super(int account, double money) {
		double funds;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			PreparedStatement statement = con.prepareStatement("select savings from accounts where userid = ? ");
			statement.setInt(1, account);
			ResultSet rs = statement.executeQuery();
			rs.next();
			if (rs.getDouble(1) - money <= 0) {
				System.out.println("You do not have enough money to withdraw that amount");
			} else {
				funds = rs.getDouble(1) - money;
				PreparedStatement statement2 = con
						.prepareStatement("update accounts set savings = ? where userid = ? ");
				statement2.setDouble(1, funds);
				statement2.setInt(2, account);
				statement2.executeUpdate();

				System.out.println("Your new balance is: $" + funds);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAccount_Super(int account) {
		int customersAdded = 0;
		CallableStatement cs = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			con.setAutoCommit(false);
			String sql = "{call DELETE_ACCOUNT("+account+")}";
			cs = con.prepareCall(sql);
			cs.execute();
			System.out.println("The account has been deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
