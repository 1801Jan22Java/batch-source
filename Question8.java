package com.revature.homework1;

import java.util.ArrayList;
public class Question8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("karan");
		names.add("madam");
		names.add("tom");
		names.add("civic");
		names.add("radar");
		names.add("jimmy");
		names.add("kayak");
		names.add("john");
		names.add("refer");
		names.add("billy");
		names.add("did");
		
		
		for(int i=0; i<names.size(); i++) {
			if(names.contains('a')) {
				System.out.println("This is a palindrome.");
			}
			if(names.contains('e')) {
				System.out.println("This is a palindrome.");
			}
			if(names.contains('i')) {
				System.out.println("This is a palindrome.");
			}
			if(names.contains('o')) {
				System.out.println("This is a palindrome.");
			}
			if(names.contains('u')) {
				System.out.println("This is a palindrome.");
			}
			else {
				System.out.println("This is not a palindrome.");
			}
		}
		

	}

}
