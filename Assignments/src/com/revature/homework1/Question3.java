package com.revature.homework1;

public class Question3 {
	

	
	public static String reverse(String str) {
		
			int originalLength = str.length();
		  
		  for (int i = originalLength  -1; i >= 0; --i) {
		  
		  str += str.charAt(i);
		  
		  }
		  
		  str = str.substring(originalLength);
		  
		 
		  
		 
		  return str;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(reverse("this string reversed"));
	}

}
