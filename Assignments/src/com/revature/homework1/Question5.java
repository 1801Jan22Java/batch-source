package com.revature.homework1;

public class Question5 {
	public static String substring(String str, int idx) {
		String string = str;
		int end = idx;
		// string to which substring characters will be appended
		String subordinateString = "";
		// for each character between stringStart and specified endIndex
		for (int i = 0; i < end; i++) {
			// append character at index to subordinateString
			subordinateString += string.charAt(i);
		}
		return subordinateString;
	}
}
