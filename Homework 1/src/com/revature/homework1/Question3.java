//Done!

package com.revature.homework1;

public class Question3 {
	public static void reverser(String s) {
		
		//Instantiate a new StringBuilder object.
		StringBuilder sb = new StringBuilder(s);
		int initialSize = sb.length();
		
		//Add the characters in the string to the end of
		//the string in reverse order.
		for(int i = initialSize-1; i >= 0; i--) {
			sb.append(sb.charAt(i));
		}
		
		//Remove the initial string, which is in the first
		//initialSize indices of sb.
		sb.delete(0, initialSize);
		System.out.println("The reversed string is " + sb.toString());
	}
	
	public static void main(String[] args) {
		//ENTER THE STRING TO BE REVERSED HERE
		String s = "dogs";
		System.out.println("The initial string is  " + s);
		Question3.reverser(s);
	}
}
