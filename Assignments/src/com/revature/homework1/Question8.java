package com.revature.homework1;

import java.util.ArrayList;

public class Question8 {
	
	public static void main(String[] args) {
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("karan");
		a.add("madam");
		a.add("tom");
		a.add("civic");
		a.add("radar"); 
		a.add("jimmy"); 
		a.add("kayak"); 
		a.add("john"); 
		a.add("refer"); 
		a.add("billy"); 
		a.add("did");
		
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(String s : a) {
			String reversed = new StringBuilder(s).reverse().toString();
			if(s.equals(reversed)) {
				palindromes.add(s);
			}
		}
		
		
	}

}
