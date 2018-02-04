package src.com.revature.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import src.com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String [] args) {
		Connection con = null;
		
		try {
			con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			System.out.println(con.getMetaData().getDriverName());
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
