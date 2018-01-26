package com.revature.homework1;

public class Question3 {
	
	public static void reverseString(String s) {
		for(int i = s.length()-1; i>=0; i--) {
			System.out.print(s.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		
		reverseString("give me a good grade");
	}
}
