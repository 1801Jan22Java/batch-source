package doa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.User;
import beans.UserInfo;
import util.ConnectionUtil;

public class UserInfoDAOImpl implements UserInfoDAO
{
	private static String filename = "Properties";
	@Override
	public ArrayList<UserInfo> getUserInfo() {
		ArrayList<UserInfo> userInfo = new ArrayList<UserInfo>();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM USER_INFO";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next())
			{
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String state = rs.getString("STATE");
				String zip = rs.getString("ZIP");
				Date bDay = rs.getDate("BIRTH_DATE");
				String address = rs.getString("ADDRESS");
				String ssn = rs.getString("SSN");
				int userId = rs.getInt("USER_ID");
				UserInfo ui = new UserInfo(firstName, lastName, state, zip, bDay, address, ssn, userId);
				userInfo.add(ui);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return userInfo;
	}

	@Override
	public UserInfo getUserinfoByUserID(int id) {
		ArrayList <UserInfo> userInfo = this.getUserInfo();
		for(UserInfo ui: userInfo)
		{
			if(ui.getUserId()==id)
				return ui;
		}
		return null;
	}

}
