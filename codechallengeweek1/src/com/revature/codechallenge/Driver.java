package com.revature.codechallenge;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	public static void main(String[] args) {
		
		List<String> bank = new ArrayList<String>();
		bank.add("ACTT");
		bank.add("ACAG");
		
		MinimumMutation test = new MinimumMutation("ACTC", "ACAG", bank);
		System.out.println(test.checkForMutations());

	}
}
