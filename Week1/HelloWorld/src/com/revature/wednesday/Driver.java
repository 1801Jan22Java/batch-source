package com.revature.wednesday;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		//funWithHashCodeAndEquals();
		//funWithArrays();
		
		//funWithVarargs();
		//funWithVarargs("cat");
		//funWithVarargs("cat", "dog", "bird");
		
		funWithStrings();
	}

	public static void funWithArrays()
	{
		//ways to declare
		int[] intArray1 = {5, 6, 7};
		int[] intArray2 = new int[] {1,2,3};
		int[] intArray3 = new int[5];
		int intArray4[] = new int[6];
		
		//prints out reference location of intArray1
		System.out.println(intArray1.toString());
		//prints out contents of intArray1
		System.out.println(Arrays.toString(intArray1));
		
		
		//2d arrays
		int[][] intArray5 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] intArray6 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] intArray7 = new int[3][4];
		System.out.println(intArray5.toString());
		System.out.println(Arrays.toString(intArray5));
		
		//use this for printing 2D arrays
		for(int i = 0; i < intArray5.length; i++)
			System.out.println(Arrays.toString(intArray5[i]));
		
		//also do
		for(int[] i : intArray5)
			System.out.println(Arrays.toString(i));
		
		//Use nested loops for accessing specific items.
	}
	
	//method will take a variable number of String arguments
	//vararg must be the last argument
	//can be any type
	public static void funWithVarargs(String ...a) //this method is able to accept variable name arguments
	{
		for(String s : a)
			System.out.println(s);
	}
	
	public static void funWithHashCodeAndEquals()
	{
		// TODO Auto-generated method stub
		Batch b1 = new Batch("1801Jan22", "Java", new String[]{"Eric", "Paul", "John", "Katrina"});
		System.out.println(b1.hashCode());
		Batch b2 = new Batch("1801Jan22", "Java", new String[]{"Gienel", "Jennifer", "AJ", "Jerric"});
		System.out.println(b2.hashCode());
		
		System.out.println(b1.equals(b2));
	}
	
	public static void funWithStrings()
	{
		String a = "cow";
		String b = new String("cow");
		
		//will print false because the reference objects are different
		System.out.println(a==b);
		
		//will print true because the values of the reference objects are the same
		System.out.println(a.equals(b));
		
		//STRING API METHODS
		
		//indexOf
		String str = "indexOf";
		System.out.println(str.indexOf('x'));
		
		//isEmpty
		str = "empty";
		if(str.isEmpty())
			System.out.println("String has length zero");
		else
			System.out.println("String has length " + str.length());
		
		//format; can replace things.
		str = "hello";
		System.out.println(String.format("%s world", str));
		
		//split
		str = "whatchuknowaboutmehNoIdon'tknowAboutDat";
		System.out.println(Arrays.toString(str.split("w")));
		for(String w : str.split("w"))
			System.out.println(w);
		
		/**
		 * Note: String API contains many other useful methods
		 * i.e.: concat, contains, substring, trim, getChars, etc.
		 */
		//StringBuilder
		str = "erutaver";
		StringBuilder sb = new StringBuilder(str);
		System.out.println(sb.reverse());
		
		//comparing StringBuilders
		StringBuilder sb2 = new StringBuilder("revature");
		
		//Let's compare them both.
		System.out.println(sb.hashCode());
		System.out.println(sb2.hashCode());
		
		String str2 = "revature";
		String str3 = "revature";
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		
		//modify sb2's value
		System.out.println(sb2.hashCode());
		StringBuilder sb3 = sb2.append("!");
		System.out.println(sb3.hashCode());
		System.out.println(sb2.equals(sb3));
	}
}