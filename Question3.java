package com.revature.homework1;

class Question3{
	
	public static void main(String[] args) {
		System.out.println(reverseString("okay"));
	}
	
	static String reverseString(String target) {
		String result = "";
		for (int x = target.length()-1; x >=0; x--)
			result += target.charAt(x);
		return result;
			
	}
}