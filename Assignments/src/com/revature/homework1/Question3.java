package com.revature.homework1;

public class Question3 {
	

	
	public static String reverse(String str) {
		//
		int originalLength = str.length();
		// adds the reversed elements of str to str
		for (int i = originalLength  -1; i >= 0; --i) {
		 str += str.charAt(i);
		  
		  }
		  //removes the original string from the reversed part of string
		  str = str.substring(originalLength);

		  return str;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(reverse("this string reversed"));
	}

}
