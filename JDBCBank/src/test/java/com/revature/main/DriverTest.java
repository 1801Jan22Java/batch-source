package com.revature.main;

import static org.junit.Assert.*;


import java.util.Scanner;

import org.junit.Test;




public class DriverTest {

	Scanner sc = new Scanner(System.in);
	
	
	
	@Test
	public final void accountLoginAndCreation() {
		
		assertNotNull(Driver.accountCreation(sc, "hello"));
		
		assertNotNull(Driver.passwordCreation(sc));
		
		assertNotNull(Driver.userInfoCreation(sc, "dunno", "do know"));
		

	}
	
	
	
	
}
