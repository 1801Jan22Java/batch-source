package com.revature.codeChallenge1;

import java.util.Arrays;

public class Driver {

	static final String start = "AACCGCTA";		 
	static final String end = "AACCGCTA";		 
	static final String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
	
	public static void main(String[] args) {
		
		checkMutation(start, end, bank);
		 
	}
	
	public static int checkMutation(String start, String end, String[] bank) {

		if (Arrays.asList(bank).indexOf(end) < 0) {
			System.out.println("It's not a valid mutation : return -1");
			return -1;
		}
		
		String[] starts = start.split("");
		String[] ends = end.split("");
		
		int mutation = 0;
		for (int i = 0 ; i <starts.length ; i++) {
			System.out.println(starts[i] + "/" + ends[i]);
			if(!starts[i].equals(ends[i])) {
				mutation++;
			};
		}
		 
		System.out.println(mutation + " times mutation occured on the gene " + start);
		return mutation;
		
	}
	
}
