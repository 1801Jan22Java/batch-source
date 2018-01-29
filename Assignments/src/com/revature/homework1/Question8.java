package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Question8 {
	
	
	public static ArrayList<String> palindromeFilter(ArrayList<String> list){
		
		ArrayList<String> filteredList = new ArrayList<>() ;
		
		for (int i = 0; i < list.size();i++) {
			StringBuilder temp = new StringBuilder();
			temp.append(list.get(i).toString());
			// uses built in StringBuilder function to reverse a word and .equals to check if equal to original
			if( temp.reverse().toString().equals(list.get(i))) {
				
				filteredList.add(list.get(i)); // adds to filtered list if reversed is the same
			}
		}
		return filteredList;
		
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<String> nameList = new ArrayList<>() ;
		nameList.add("karan");
		nameList.add("madam");
		nameList.add("tom");
		nameList.add("civic");
		nameList.add("radar");
		nameList.add("jimmy");
		nameList.add("kayak");
		nameList.add("john");
		nameList.add("refer");
		nameList.add("billy");
		nameList.add("did");
		
		//creates new list to store palindromes
		ArrayList<String> emptyList = new ArrayList<>() ;
		
		emptyList = palindromeFilter(nameList);
		for (int i = 0; i < emptyList.size();i++) {
			System.out.println( emptyList.get(i));
			
			
		}
		
		
		
	
		
	}
	

}
