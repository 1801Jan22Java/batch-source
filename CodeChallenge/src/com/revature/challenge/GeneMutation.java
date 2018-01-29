package com.revature.challenge;

import java.util.ArrayList;

public class GeneMutation {

	public static int mutation(ArrayList<String> bank, StringBuilder start, StringBuilder end) {
		int returnValue = -1;
		for(String s : bank) {
			if(s.equals(start)) {
				returnValue = 0;
			}
		}
		
		while(start != end) {
		
		for(int i = 0; i < bank.size(); i++) {
			if(bank.get(i).length() == start.length()) {
			for(int j = 0; j < bank.get(i).length() ; i++ ) {
				
				if (bank.get(i).charAt(i) == start.charAt(i)) {
					start.replace(i, i, bank.get(i));
					returnValue++;
				}
			}	
			}	
			if (start.equals(end)) { 
				continue;
				
				
		}
		
		}
		
		
	}
		return returnValue;
	
	

		
		
	}
	public static void main(String[] args) {
	ArrayList<String> test = new ArrayList<String>();
	test.add("AACCGGTA");
	StringBuilder startTest = new StringBuilder("AACCGGTA");
	StringBuilder endTest = new StringBuilder("AACCGGTA");
	System.out.println(mutation(test, startTest, endTest));
		
}
	
}
