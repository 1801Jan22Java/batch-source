package com.revature.codechallenge;

import java.util.ArrayList;

public class CodeChallenge {

	public static void main(String[] args) {
		
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		
		ArrayList<String> bank = new ArrayList<>();
		bank.add("AACCGGTA");
		bank.add("AACCGCTA");
		bank.add("AAACGGTA");
		
		Utility check = new Utility(start, end, bank);
		
		check.checkSequence();
		
	}

}
