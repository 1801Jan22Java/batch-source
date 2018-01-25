//Done!

package com.revature.homework1;
import java.util.*;

public class Question8 {
	public static void main(String[] args) {
		
		//Create the ArrayList with the specified values
		ArrayList<String> original = new ArrayList<String>();
		original.add("karan");
		original.add("madam");
		original.add("tom");
		original.add("civic");
		original.add("radar");
		original.add("jimmy");
		original.add("kayak");
		original.add("john");
		original.add("refer");
		original.add("billy");
		original.add("did");
		
		//Find the palindromes
		
		//Create another ArrayList to hold the palindromes
		ArrayList<String> palindromes = new ArrayList<String>();
		
		//Default value of this flag is set to true.
		boolean flag = true;
		for(String s : original) {
			flag = true;
			for(int i = 0; i < s.length()/2; i++)
			{
				//If the two compared characters are not the same, the word is not a palindrome
				if(s.charAt(i) != s.charAt(s.length()-1-i)) {
					flag = false;
				}
			}
			
			//If this word is a palindrome, add it to the palindromes ArrayList
			if(flag == true) {
				palindromes.add(s);
			}
		}
		
		//Use an enhanced for-loop to print the palindromes
		System.out.print("Palindromes are: ");
		for(String palin : palindromes) {
			System.out.print(palin + " ");
		}
	}
}
