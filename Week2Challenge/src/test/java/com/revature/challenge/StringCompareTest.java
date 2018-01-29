package com.revature.challenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCompareTest {

	
	@Test
	public final void validStringsInCompare7() {
		int numEquals = StringCompare.strCompare("AAAAAAAA", "AAAAAAAT");
		
		if(numEquals == 7) {
			assert(true);
		}
		else {
			assert(false);
		}
	}
	
	@Test
	public final void validStringsInCompareAllEqual() {
		int numEquals = StringCompare.strCompare("CCCCCCCC", "CCCCCCCC");
		
		if(numEquals == 8) {
			assert(true);
		}
		else {
			assert(false);
		}
	}
	
	@Test
	public final void validStringsInCompareNoneEqual() {
		int numEquals = StringCompare.strCompare("TTTTTTTT", "CCCCCCCC");
		
		if(numEquals == 0) {
			assert(true);
		}
		else {
			assert(false);
		}
	}
}
