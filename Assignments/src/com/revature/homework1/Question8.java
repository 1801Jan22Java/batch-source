package com.revature.homework1;
import java.util.*;
public class Question8 {
	private static String[] words = new String[] {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
	private static ArrayList<String> list = new ArrayList();
	private static ArrayList<String> palList = new ArrayList();
	private static boolean palindrome(String str){
		for (int i = 0; i<=str.length()/2; i++)
		{
			if(str.charAt(i)!=str.charAt(str.length()-(i+1))) 		//compare char at beginning and end until it reaches the middle
			{
				return false;										//if they aren't equal its not a palindrome return false
			}
		}
		return true; 												//all the beginning and ending letters match return true
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list.addAll(Arrays.asList(words));				//add all words at once
		System.out.print("Original list of words:");	//print them out
		for(String str : list)
		{
			System.out.print(" " + str + ",");
		}
		System.out.println();
		for(String str : list)							//cycle through arrayList 
		{
			if(palindrome(str))
			{
				palList.add(str);						//test each word to find out if its a palindrome
			}
		}
		System.out.print("List of palindromes:");		// print out the palindromes
		for(String str : palList)
		{
			System.out.print(" " + str + ",");
		}
	}

}
