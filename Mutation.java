package com.revature.codechallenge;

import java.util.ArrayList;

public class Mutation {

	private String Start;
	private String end;
	
	public Mutation(String str, String end) {
		this.Start = str;
		this.end = end;
		
		
	
		ArrayList<String> Bank = new ArrayList<String>();
		Bank.add("AACCGGTA");
		Bank.add("AACCGTA");
		Bank.add("AAACGGTA");
		
		if(str.equals(end)) {
			System.out.println(0);
		}
		else {
			System.out.println(-1);
		}
	
}

	public String getStart() {
		return Start;
	}

	public void setStart(String start) {
		Start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	
}


