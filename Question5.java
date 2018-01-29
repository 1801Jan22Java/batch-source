package com.revature.homework1;

class Question5{
	
	public static void main(String[] args) {
		//String a = "1234";
		//System.out.println(subStr(a,2));
	}
	
	static String subStr(String str, int idx) {
		String substring = "";
		for (int x = 0; x < idx; x++)
			substring += str.charAt(x);
		return substring;
	}
}