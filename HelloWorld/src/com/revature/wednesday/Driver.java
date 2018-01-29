package com.revature.wednesday;

import java.util.Arrays;

public class Driver 
{
	public static void main(String args[])
	{
		String[] members1 = {"Calder","Kiera","Chad"};
		Batch b1 = new Batch("1801Jan22","Java", members1);
		//System.out.println(b1.hashCode());
		
		String[] members2 = {"Matt", "Conan, Sungkwon"};
		Batch b2 = new Batch("1801Jan22","Java", members2);
		//System.out.println(b2.hashCode());
		//System.out.println(b1.equals(b2));
		//funWithArrays();
		String[] herp = {"herp"};
		//funWithVarargs(herp);
		funWithStrings();
	}
	public static void funWithArrays()
	{
		//ways to declare arrays
		int [] intArray1 = {5,6,7};
		int [] intArray2 = new int[7];
		int intArray3[] = new int[7];//legal but hard to look at and understand
		
		System.out.println(intArray1.toString());
		//use the arrays utility method 
		//also has a sort, serach, etc
		System.out.println(Arrays.toString(intArray1));
		
		//not limited to one dimension
		int[][]intArray4 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][]intArray5 = new int[3][4];
		System.out.println(Arrays.toString(intArray4));
		
		//you can iterate with a nested for loop or...
		for(int i =0; i < intArray4.length;i++)
		{
			for(int j = 0; j<intArray4[i].length;j++)
			{
				System.out.print(intArray4[i][j] +" ");
			}
			System.out.println();
		}
		//you can use a for loop and the array utility
		for(int i =0; i < intArray4.length;i++)
		{
			System.out.println(Arrays.toString(intArray4[i]));
		}
		for(int[] i : intArray4)
		{
			System.out.println(Arrays.toString(i));
		}
	}
	//varargs
	//method will take a variable number of String arguments
	//vararg must be the last argument
	//can be any type
	public static void funWithVarargs(String...a)
	{
		//moving through the varargs
		//we can treat it as an iterable
		for(String s: a)
		{
			System.out.println(s);
		}
	}
	public static void funWithStrings()
	{
		//two different ways to create a string
		String a = "cow";
		String b = new String("cow");
		//returns false because they are comparing the object, not the reference
		System.out.println(a==b);
		//returns true, for the opposite reason
		System.out.println(a.equals(b));
		String str3 = "Hello";
		//String API methods
		String str1 = "indexOfx";
		//the second argument allows you to start looking at a certain index
		System.out.println(str1.indexOf('x',5));
		//Checks is a string is empty
		System.out.println(str1.isEmpty());
		//format
		System.out.println(String.format("%s world", str3));
		//split 
		//allows you to set something as a delimiter
		String str4 = "java-string-split-method";
		String[] words = str4.split("-");
		for(String s: words)
		{
			System.out.println(s);
		}
		/*
		 * note:
		 * String API also contains other useful methods like...
		 * concat
		 * contains
		 * substring
		 * trim
		 * getChars
		 * compareTo
		 */
		
		//StringBuilder
		//Mutable,
		String str5 = "erutaver";
		StringBuilder sb = new StringBuilder(str5);
		System.out.println(sb.reverse());
		//compare StringBuilders
		StringBuilder sb2 = new StringBuilder("revature");
		System.out.println("SB1 Harshcode: "+sb.hashCode());
		System.out.println("SB2 Harshcode: "+sb2.hashCode());
		//hashcodes are not the same
		String str6 = "revature";
		String str7 = "revature";
		System.out.println("Str6 Harshcode: "+str6.hashCode());
		System.out.println("Str7 Harshcode: "+str7.hashCode());
		//hashcodes are the same!!
		
		//modify sb2's value!!
		System.out.println(sb2.hashCode());
		StringBuilder sb3 = sb2.append("!");
		System.out.println(sb3.hashCode());
	}
}
