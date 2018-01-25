//Done!

package com.revature.homework1;

public class Question6 {
	public static boolean isEven(int num) {
		//Create an Integer object with the int num
		Integer numWrapped = new Integer(num);
		
		//Convert the Integer object to a String using toString()
		String numStr = numWrapped.toString();
		
		//If the last character in numStr is 0, 2, 4, 6 or 8, it is even, so return true
		if(numStr.charAt(numStr.length()-1) == '0' ||
				numStr.charAt(numStr.length()-1) == '2' ||
				numStr.charAt(numStr.length()-1) == '4' ||
				numStr.charAt(numStr.length()-1) == '6' ||
				numStr.charAt(numStr.length()-1) == '8') {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int num = 5;		//Enter the integer to check here
		
		System.out.println(num + " is even: " + Question6.isEven(num));
	}
}
