package com.revature.codechallenge;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	public static void main(String[] args) {
		
		List<String> bank = new ArrayList<String>();
		bank.add("AACCGGTA");
		bank.add("AACCGGTA");
		bank.add("AAACGGTA");
		
		MinimumMutation test = new MinimumMutation("AACCGGTT", "AAACGGTA", bank);
		System.out.println(test.checkForMutations());

	}
}
