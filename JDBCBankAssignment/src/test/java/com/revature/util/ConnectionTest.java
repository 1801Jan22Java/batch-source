package com.revature.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionTest {

	@Test(expected= IOException.class)
	public final void testInvalidFile() throws IOException, SQLException {
		ConnectionUtil.connectToDatabase("Fakefilename.fake");	
	}

	@Test
	public final void testNullConnection()  {
		assertNull(ConnectionUtil.connection);
	}
	
	@Test
	public final void testValidConnection()  {
		try {
			ConnectionUtil.connectToDatabase("Connection.Properties");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		assertNotNull(ConnectionUtil.connection);
	}
	
}
