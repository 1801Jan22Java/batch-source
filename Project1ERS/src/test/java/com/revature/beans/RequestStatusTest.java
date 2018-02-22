package com.revature.beans;
import static org.junit.Assert.*;

import org.junit.Test;

public class RequestStatusTest {

	@Test
	public final void testAssertions() {
		
		RequestStatus thisRequestStatus = new RequestStatus(1, "Pending");
		
		// Returns 1 from thisEvent
		assertEquals(thisRequestStatus.getKey(), 1);
		
		thisRequestStatus.setKey(10);
		// Returns 1 from thisEvent
		assertEquals(thisRequestStatus.getKey(), 10);
		
		// Returns "Travel" from thisEvent
		assertEquals(thisRequestStatus.getValue(), "Pending");
		
		thisRequestStatus.setValue("Approved");
		// Returns "Travel" from thisEvent
		assertEquals(thisRequestStatus.getValue(), "Approved");
		
	}
}
