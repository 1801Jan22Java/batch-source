package com.revature.challenge;


public class StringCompare {
	
	private String str1;
	private String str2;
	public StringCompare() {
		
	}
	
	public StringCompare(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}
	
	
	//This method returns the number of characters in common these strings have
	public static int strCompare(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return -1;
		}
		int identical = 0;
		for(int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) == str2.charAt(i)) {
				identical++;
			}
/*			if(str1.charAt(i) != 'A' || str1.charAt(i) != 'C' || str1.charAt(i) != 'G' || str1.charAt(i) != 'T' || 
					str2.charAt(i) != 'A' || str2.charAt(i) != 'C' || str2.charAt(i) != 'G' || str2.charAt(i) != 'T' ) {
				return -2;	//Not valid input
			}*/
				
		}
		return identical;
		
	}
	
	public static int takeSteps(String start, String end, String[] bank) {
		int numSteps = 0;
		boolean valid = false;
		
		while(!start.equals(end)) {
			valid = false;
			for(String s : bank) {
				if(StringCompare.strCompare(start,s) == -2) {
					return -2;
				}
				if(StringCompare.strCompare(start, s) == (start.length()-1) &&
						StringCompare.strCompare(s, end) - StringCompare.strCompare(start, end) == 1 ) {
					start = s;
					valid = true;
					break;
				}
				
			}
			if(valid == true) {
				numSteps++;
			}
			else {
				return -1;
			}
		}
		return numSteps;
	}
}
