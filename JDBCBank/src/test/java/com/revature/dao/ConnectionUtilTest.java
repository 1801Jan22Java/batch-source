package com.revature.dao;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import com.revature.beans.User;


public class ConnectionUtilTest {

	@Test
	public void getConnectionTest () {
		User user = new User();
		try {
		ConnectionUtil.getConnection("bank.properties", user);
		assertNotNull("Connection Successful", user.getConn());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
