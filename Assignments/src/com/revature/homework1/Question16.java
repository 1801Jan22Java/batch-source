package com.revature.homework1;

public class Question16 {
	public static void numOfChars(String[] args) {
		
		int sum = 0;
		
		//Add all the lengths of each Array element to the sum
		for(int i = 0; i < args.length; i++) {
			sum += args[i].length();
		}
		
		System.out.println(sum);
	}
}
