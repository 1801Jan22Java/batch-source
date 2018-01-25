//Done!

package com.revature.homework1;

public class Question5 {
	
	public static String substr(String str, int idx) {
		
		//Create a new StringBuilder object to append the first idx
		//chars of str to
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i <= idx-1; i++) {
			sb.append(str.charAt(i));
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		//Enter values for str and idx here
		String str = "meow";
		
		//How many chars in str to print
		int idx = 3;			
		
		String result = Question5.substr(str, idx);
		System.out.println("The first " + idx + " characters in " + str + " are: " + result);
	}
	
}
