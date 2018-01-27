package com.revature.homework1;

public class Question5 {
	
	public static String subString(String str, int idx) {
		
		// if the index is larger than the length of the string then return the string 
		if (idx >= str.length()) {
			return str;
		}
		
		// find the substring from 0 to idx - 1
		String temp = "";
		String [] arr = str.split("");
		for (int i = 0; i < idx; i++) {
			temp += arr[i];
		}
		return temp;
	}
	public static void main(String[] args) {
		
		System.out.println(subString("hello",5));
		
	}

}
