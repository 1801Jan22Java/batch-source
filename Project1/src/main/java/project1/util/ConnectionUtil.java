package project1.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static String filename = "connection.properties";
	
	//getConnection() maven edition
	public static Connection getConnectionFromFile() throws IOException, SQLException{
		//make sure the driver is being seen by maven
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		//treating properties file as a resource for maven
		try {
		prop.load(loader.getResourceAsStream(filename));
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
}
