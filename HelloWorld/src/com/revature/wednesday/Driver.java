package com.revature.wednesday;

import java.util.Arrays;

public class Driver {
	
	public static void main(String[] args) {
		
		String[] members1 = {"Calder", "Kiera", "Chad"};		
		Batch b1 = new Batch("1801Jan22", "Java", members1);
		
		System.out.println(b1.hashCode());
		
		String[] members2 = {"Matt", "Conan", "Sungkwon"};		
		Batch b2 = new Batch("1801Jan22", "Java", members2);
		
		System.out.println(b2.hashCode());
		
		System.out.println(b1.equals(b2));
		
		//funWithArrays();
		
		//funWithVarargs();
		//funWithVarargs("cat");
		//funWithVarargs("cat", "dog", "bird");
		
		funWithStrings();
	}
	
	public static void funWithArrays() {
		//ways to declare arrays
		int[] intArray1 = {5, 6, 7};
		int[] intArray2 = new int[7];
		int intArray3[] = new int[7]; //legal but horrible; confusing to look at
		
		System.out.println(intArray1.toString());
		//use the Arrays utility class for useful methods
		//also has a sort, search, etc.
		System.out.println(Arrays.toString(intArray1));
		
		//not limited to one dimension
		int[][] intArray4 = {{1,2,3,}, {4,5,6}, {7,8,9}};
		int[][] intArray5 = new int[3][4];
		System.out.println(intArray4.toString());
		//will just print out an array with object ID for each nested array
		System.out.println(Arrays.toString(intArray4));
		
		for(int i = 0; i < intArray4.length; i++) {
			System.out.print(Arrays.toString(intArray4[i]));
		}
		System.out.println();
		for(int[] i : intArray4) {
			System.out.print(Arrays.toString(i));
		}
	}
	
	//varargs
	//method will take a variable number of String arguments
	//vararg must be the last argument
	//can be any type
	public static void funWithVarargs(String ...a) {
		//moving through the varargs
		for(String i : a) {
			System.out.println(i);
		}
	}
	
	public static void funWithStrings() {
		String a = "cow";
		String b = new String("cow");
		
		//false
		System.out.println(a==b);
		
		//true
		System.out.println(a.equals(b));
		
		//String API methods
		
		//indexOf
		String str1 = "indexOfx";
		System.out.println(str1.indexOf('x', 5));
		
		//isEmpty
		String str2 = "empty";
		if(str2.isEmpty()) {
			System.out.println("string has length zero");
		} else {
			System.out.println("string has length " + str2.length());
		}
		
		//format
		String str3 = "hello";
		System.out.println(String.format("%s world", str3));
		
		//split
		String str4 = "java-string-split-method";
		String[] words = str4.split("-");
		//use .split(" ") to split on whitespace
		System.out.println(Arrays.toString(words));
		
		/*
		 * NOTE:
		 * String API also contains other useful methods:
		 * concat, contains, substring, trim, getChars, charAt
		 * compareTo, etc.
		 */
		
		//StringBuilder reverse method
		String str5 = "erutaver";
		StringBuilder sb = new StringBuilder(str5);
		System.out.println(sb.reverse());
		
		//comparing StringBuilders
		StringBuilder sb2 = new StringBuilder("revature");
		System.out.println(sb.hashCode());
		System.out.println(sb2.hashCode());
		System.out.println(sb.equals(sb2));
		
		String str6 = "revature";
		String str7 = "revature";
		System.out.println(str6.hashCode());
		System.out.println(str7.hashCode());
		
		//modify sb2's value
		System.out.println(sb2.hashCode());
		StringBuilder sb3 = sb2.append("!");
		System.out.println(sb3.hashCode());
		System.out.println(sb2.equals(sb3));
	}
	
	

}
