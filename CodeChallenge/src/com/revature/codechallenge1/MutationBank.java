package com.revature.codechallenge1;

import java.util.ArrayList;

public class MutationBank {
	
	private static ArrayList<String> bank = new ArrayList<String>();
	
	public MutationBank() {
	}
	
	public void addMutation(String str) {
		bank.add(str);
	}
	
	public boolean isValid(String gs) {
		for(String s: bank) {
			// means the string is within the bank
			if (s.equals(gs)) {
				return true;
			}
		}
		return false;
	}

}
