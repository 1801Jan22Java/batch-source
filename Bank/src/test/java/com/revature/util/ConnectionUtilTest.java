package com.revature.util;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

public class ConnectionUtilTest {
	@Test
	public final void testAssertions() {
		
		try {
			// Returns a valid Connection when existing file is passed
			assertNotNull(ConnectionUtil.getConnectionFromFile("connection.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test (expected=IOException.class)
	public final void throwsIOException() throws IOException, SQLException {
		// Throws IOException when invalid file is passed
		ConnectionUtil.getConnectionFromFile("mydoc.txt");
	}
}
