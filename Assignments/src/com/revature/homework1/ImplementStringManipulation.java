package com.revature.homework1;

public class ImplementStringManipulation {
	
	public static boolean hasUpper(String str) {
		
		return (str != str.toLowerCase());
		
	}
	
	public static String toUpper(String str) {
		
		return str.toUpperCase();
		
	}
	
	public static void convertAndAdd(String str) {
		
		int convert = Integer.valueOf(str);
		
		System.out.println(convert + 10);
		
	}

}
