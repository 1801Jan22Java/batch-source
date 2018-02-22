package com.revature.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.revature.beans.Employee;
import com.revature.beans.Request;

public class UploadDaoImplTest {
	
	@Test
	public final void testAssertions() {
		UploadDaoImpl ud = new UploadDaoImpl();
		
		Employee thisManager = new Employee(98765, "Boss", "Man", "boss@company.com", "The Boss", LocalDate.now());
		Request thisRequest = new Request(98765, "Travel", "Pending", thisManager, 100, "This is a request", LocalDate.now());
		
		// Returns false when requestid not found
		assertFalse(ud.getUploads(thisRequest));
		
		// Returns false when filename is available
		assertFalse(ud.isDuplicate("filename not found in database"));
		
		// Returns false when requestid and employeeid not found
		assertFalse(ud.addUpload("filename",thisRequest, thisManager));
	}

}
