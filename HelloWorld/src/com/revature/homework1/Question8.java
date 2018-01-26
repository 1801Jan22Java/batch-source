package com.revature.homework1;

import java.util.ArrayList;

public class Question8 {

	//Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	// “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
	public static void main(String[] args) {
		
		String[] names = { "karan" , "madam" , "tom" , "civic" , "radar" , "jimmy", "kayak" , "john" , "refer" , "billy" , "did" };
		System.out.println(ifPalindromes(names).toString());
	}
	
	public static ArrayList<String> ifPalindromes (String[] names ) {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		for (String name : names) {
		
			StringBuilder sb = new StringBuilder(name);
			
			if(name.equals(sb.reverse().toString())) {		//The palindrome is the same as the original letter when turned over.
				arrayList.add(name);
			}

		}
		return arrayList;
	}

}
