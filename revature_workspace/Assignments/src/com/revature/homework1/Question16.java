package com.revature.homework1;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
Q16. Write a program to display the number of characters for a string input. 
The string should be entered as a command line argument using (String [ ] args).

 * */
public class Question16 {
	

	
	public static String[] makeStrArray(ArrayList<String> lists){
		String [] strArray = new String[lists.size()];
		int i=0;
		for(String s: lists)
		{
			
			strArray[i]=s;
			System.out.println(strArray[i]);
			i++;
			
		}
		return strArray;
	}
	
	public static int countChars(String[] strings){
		int charCount=0;
		for(int j =0;j<strings.length;j++)
		{
			System.out.println(strings[j]);
			charCount+=strings[j].length();
		}
		return charCount;
	} 
	
	public static void main(String []args)
	{
		String [] strs = {"hot","cold","yes","no"};
		System.out.println(countChars(strs));
		Scanner sc2=new Scanner (System.in);
		ArrayList<String> lists = new ArrayList<String>();
		System.out.println("Add a string: ");
		String input = sc2.nextLine();
		lists.add(input);
		while(!input.isEmpty())
		{
			System.out.println("Add another string: ");
			input=sc2.nextLine();
			lists.add(input);
		}
	
		String[] strArray = makeStrArray(lists);
		System.out.println(strArray.length);
		System.out.println(countChars(strArray));
	
	//	countChars(args);
	}

}
