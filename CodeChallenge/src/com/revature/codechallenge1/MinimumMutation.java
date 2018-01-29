package com.revature.codechallenge1;

import java.util.ArrayList;

public class MinimumMutation {

	public MinimumMutation() {
		super();
	}

	public MinimumMutation(String start, String end, ArrayList<String> bank) {
		super();
		this.start = start;
		this.end = end;
		this.bank = bank;
	}

	private String start;
	
	private String end;
	
	private ArrayList<String> bank;

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public ArrayList<String> getBank() {
		return bank;
	}

	public void setBank(ArrayList<String> bank) {
		this.bank = bank;
	}
	
	public int checkMutation(String start, String end, ArrayList<String> bank){
		
		int mutations = 0;
		
		if(start.equals(end)) {
			return 0;
		}
		
		for(int i=0; i<start.length(); i++) {
			if(start.charAt(i)!=end.charAt(i)) {
				int check = mutations;
				boolean mutation = false;
				for(int j=0; j<bank.size(); j++) {
					if(bank.get(j).charAt(i)==end.charAt(i)) {
						mutations+=1;
						mutation = true;
					}
					if(mutation) {
						break;
					}
				}
				if(check==mutations){
					return -1;
				}
			}
		}
		return mutations;
	}
}
