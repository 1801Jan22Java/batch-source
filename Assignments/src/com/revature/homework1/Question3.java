package com.revature.homework1;

public class Question3 {
	//Reverse a string without using a temporary variable
	//or the reverse() method in StringBuffer or StringBuilder APIs

	public Question3() {
		super();
	}
	
	public static void strReverse(String str) {
		//Starting from the end of the String, you print out each character using the charAt function
		for(int i = str.length()-1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}

}
