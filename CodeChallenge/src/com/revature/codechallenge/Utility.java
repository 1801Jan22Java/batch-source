package com.revature.codechallenge;

import java.util.ArrayList;

public class Utility {
	
	int mutateCount;
	String start;
	String end;
	ArrayList<String> bank = new ArrayList<>();
	
	public Utility() {
		super();
	}

	public Utility(String start, String end, ArrayList<String> bank) {
		super();
		this.start = start;
		this.end = end;
		this.bank = bank;
	}
	
	public void checkSequence() {
		isSame(start, end);
		countMutate(start, end);
		
	}
	
	public int isSame(String start, String end) {
		if(start.equals(end)) {
			return 0;
		}
		
		return 1;
		
	}
	
	public void countMutate(String start, String end) {
		if(!bank.contains(end)) { // check if end string is valid in the bank
			for(int i = 0; i < start.length(); i++) {
				if (start.charAt(i) != end.charAt(i)) {
					mutateCount++;
				}
			}
		}
	}
	
	

}
