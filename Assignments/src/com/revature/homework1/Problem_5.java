package com.revature.homework1;

public class Problem_5 {
	
	public static void Sub_String(String stuff , int index) {
		String things = "";
		for(int i = 0; i< index ; i++) {
			things = things +stuff.charAt(i);
			
		}
		
		System.out.print(things);
	}

	public static void main(String args[]) {
		Sub_String("codealot",4);
		
	}
}
