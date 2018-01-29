package com.revature.codechallenge;

import java.util.List;

public class MinimumMutation {
	
	private String startPoint;
	private String endPoint;
	private List<String> bank;

	public MinimumMutation() {
		super();
	}
	
	public MinimumMutation(String startPoint, String endPoint, List<String> bank) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.bank = bank;
	}
	
	// If all the checks are cleared, it returns the number of mutations necessary
	public int checkForMutations() {
		int num = 0;
		if(this.checkBank() == -1) {
			num = -1;
		} else if(this.checkEndPoint() == 0) {
			num = 0;
		} else {
			num = this.howManyChanges();
		}
		
		return num;
	}
	
	// Checks the Strings in the bank
	public int checkBank() {
		boolean hasMutation = true;
		for(String gene : this.bank) {
			//Check if the bank has only the four letters in a gene
			for(int i = 0; i < gene.length(); i++) {
				char c = gene.charAt(i);
				if(c != 'A' && c != 'C' && c !='G' && c !='T') {
					hasMutation = false;
				}
			}
		}
		
		// If all the characters in the bank consists of ACGT, then check if the 
		// bank has the endpoint
		if(hasMutation) {
			for(String gene: this.bank) {
				if(gene == this.endPoint) {
					hasMutation = true;
				}
			}
		}
		
		if(!hasMutation) {
			return -1;
		}
		return 0;
	}
	
	// Only go through checkEndPoint if checkBank has been ran
	public int checkEndPoint() {
		if(this.endPoint.equals(this.startPoint)) {
			return 0;
		}
		return -1234;
	}
	
	
	// Return the count of mutations
	// Goes through and checks how many changes are required to get from start to end point
	public int howManyChanges() {
		int count = 0;
		for(int i = 0; i < this.endPoint.length(); i++) {
			if(this.startPoint.charAt(i) != this.endPoint.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
