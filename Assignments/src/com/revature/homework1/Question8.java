package com.revature.homework1;

import java.util.ArrayList;

public class Question8 {
	public static void main(String[] args) {
		@SuppressWarnings("serial")
		ArrayList<String> lst = new ArrayList<String>() {{
			add("karan"); 
			add("madam");
			add("tom"); 
			add("civic");
			add("radar");
			add("jimmy");
			add("kayak");
			add("john");
			add("refer");
			add("billy");
			add("did");
		}};
		
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(String s:lst) {
			if(s.equals(new StringBuffer(s).reverse().toString())) {
				palindromes.add(s);
			}
		}
		
		for(String p:palindromes) {
			System.out.println(p);
		}
	}
}
