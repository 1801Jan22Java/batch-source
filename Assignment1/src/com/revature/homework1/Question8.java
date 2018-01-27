package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Question8 
{
	public static void wordsAndTheirPalindromes()
	{
		String w0 = "karan";
		String w1 = "madam";
		String w2 = "tom";
		String w3 = "civic";
		String w4 = "radar";
		String w5 = "jimmy";
		String w6 = "kayak";
		String w7 = "john";
		String w8 = "refer";
		String w9 = "billy";
		String w10 = "did";
		
		ArrayList<String> words = new ArrayList<String>();
		words.add(w0);
		words.add(w1);
		words.add(w2);
		words.add(w3);
		words.add(w4);
		words.add(w5);
		words.add(w6);
		words.add(w7);
		words.add(w8);
		words.add(w9);
		words.add(w10);
		
		ArrayList<String> palindromes = new ArrayList<String>();
		
		//temp is used for storage.
		StringBuilder sb = null;
		String temp = "";
		for(String s : words)
		{
			sb = new StringBuilder(s);
			sb.reverse();
			temp += sb.toString();
			if(s.length()%2 == 0)
				palindromes.add(temp += s);
			else
				palindromes.add(temp.substring(1));
		}
		
		System.out.println(Arrays.toString(palindromes.toArray()));
	}
}
