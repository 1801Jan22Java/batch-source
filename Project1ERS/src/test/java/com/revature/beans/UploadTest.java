package com.revature.beans;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class UploadTest {
	
	@Test
	public final void testAssertions() {
		
		Employee thisManager = new Employee(1, "Boss", "Man", "boss@company.com", "The Boss", LocalDate.now());
		Upload thisUpload = new Upload(1, "filename.jpg", "sjdhngkd.jpg", LocalDate.now(), thisManager);
		
		// Returns "filename.jpg" from thisEvent
		assertEquals(thisUpload.getFilename(), "sjdhngkd.jpg");
		
		thisUpload.setFilename("lfjdjejerjf.jpg");
		// Returns "Travel" from thisEvent
		assertEquals(thisUpload.getFilename(), "lfjdjejerjf.jpg");

		// Returns Date object
		assertNotNull(thisUpload.getCreationDate());

		// Returns 1 from thisEvent
		assertEquals(thisUpload.getUploadId(), 1);
		
		thisUpload.setUploadId(10);
		// Returns 10 from modified thisEvent
		assertEquals(thisUpload.getUploadId(), 10);

		// Returns "filename.jpg" from thisEvent
		assertEquals(thisUpload.getDisplayName(), "filename.jpg");
		
		thisUpload.setDisplayName("newfilename.jpg");
		// Returns "Travel" from thisEvent
		assertEquals(thisUpload.getDisplayName(), "newfilename.jpg");
		
		// Returns Employee object
		assertNotNull(thisUpload.getUploadAuthor());
	}

}
