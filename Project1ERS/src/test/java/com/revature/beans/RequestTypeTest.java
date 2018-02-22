package com.revature.beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class RequestTypeTest {
	
	@Test
	public final void testAssertions() {
		
		RequestType thisRequestType = new RequestType(1, "Travel");
		
		// Returns 1 from thisEvent
		assertEquals(thisRequestType.getKey(), 1);
		
		thisRequestType.setKey(10);
		// Returns 1 from thisEvent
		assertEquals(thisRequestType.getKey(), 10);
		
		// Returns "Travel" from thisEvent
		assertEquals(thisRequestType.getValue(), "Travel");
		
		thisRequestType.setValue("Medical");
		// Returns "Travel" from thisEvent
		assertEquals(thisRequestType.getValue(), "Medical");
		
	}

}
