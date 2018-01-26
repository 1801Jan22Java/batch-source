package com.revature.homework1;

public class Question5 {
	
	public static String writeSubString(String str, int idx) {
		
		//By using a StringBuilder, add to existing stringBuilder the character at each index up to index given
		StringBuilder strBuilder = new StringBuilder();
		for(int i = 0; i <= idx; i++) {
			strBuilder.append(str.charAt(i));
		}
		
		return strBuilder.toString();
	}
}
