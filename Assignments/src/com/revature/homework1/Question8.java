package com.revature.homework1;

import java.util.ArrayList;

public class Question8 {
	public static ArrayList<String> palindromes(ArrayList<String> list) {
		ArrayList<String> fullList = list;
		ArrayList<String> palindromes = new ArrayList<String>();
		// for each string in the passed list of strings
		for (String s : fullList) {
			// compares string to the reversed string
			if (Question3.stringReverser(s).equals(s)) {
				// if equal, adds to the list of palindromes
				palindromes.add(s);
			}
		}
		return palindromes;
	}
}
