package com.revature.wednesday;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		Driver.funWithStrings();
	}
	
	public static void funWithStrings() {
		String a = "cow";
		String b = new String("cow");
		
		//What is this?
		System.out.println(a==b);	//False because they're different objects, despite having equivalent string literals
		
		System.out.println(a.equals(b));
		
		//String API methods
		
		//indexOf
		String str1 = "indexOfx";
		System.out.println(str1.indexOf('x', 5));	//Second parameter determines where to start search
		
		//isEmpty
		String str2 = "empty";
		if(str2.isEmpty()) {
			System.out.println("string has length zero");
		}
		else {
			System.out.println("string has length " + str2.length());
		}
		
		//format
		String str3 = "hello";
		System.out.println(String.format("%s world",  str3));
		
		//split
		String str4 = "java-string-split-method";
		String[] words = str4.split("-");
		//use .split(" ") to split on whitespace
		for(String w : words) {
			System.out.println(w);
		}
		
		/*
		 * Note:
		 * String API also contains other useful methods like
		 * concat, contains, substring, trim, getChars,
		 * compareTo, etc.
		 */
		
		
		//StringBuilder
		
		//Reverse Method
		String str5 = "erutaver";
		StringBuilder sb = new StringBuilder(str5);
		sb.reverse();
		System.out.println(sb.toString());
		
		//Comparing StringBuilders
		StringBuilder sb2 = new StringBuilder("revature");
		System.out.println(sb.hashCode());
		System.out.println(sb2.hashCode());		//These two StringBuilder objects do NOT have the same hashcodes
		
		String str6 = "revature";
		String str7 = "revature";
		System.out.println(str6.hashCode());
		System.out.println(str7.hashCode());	//These two strings have the same hashcodes.
		
		//Modify sb2's value
		System.out.println(sb2.hashCode());
		StringBuilder sb3 = sb2.append("!");	//Both sb2 and sb3 have the same hashcodes and have ! appended
		System.out.println(sb3.hashCode());
		System.out.println(sb2.equals(sb3));
	}
	
	public static void funWithHashCodeAndEquals() {
		String[] members1 = {"Calder","Kiera","Chad"};
		Batch b1 = new Batch("1801Jan22","Java", members1);
		
		System.out.println(b1.hashCode());
		
		String[] members2 = {"Matt","Conan","Sungkwon"};
		Batch b2 = new Batch("1801Jan22","Java", members2);

		System.out.println(b2.hashCode());
		
		System.out.println(b1.equals(b2));
		
		//Driver.funWithArrays();
		
		funWithVarargs();
		funWithVarargs("cat");
		funWithVarargs("cat", "dog", "bird");
	}
	
	public static void funWithArrays() {
		//ways to declare arrays
		int[] intArray1 = {5,6,7};
		int[] intArray2 = new int[7];
		int intArray3[] = new int[7];	//LEGAL BUT HORRIBLE
		
		System.out.println(intArray1.toString());
		//Use the Arrays utility class for useful methods
		//Also has sort, search, etc.
		System.out.println(Arrays.toString(intArray1));
		
		//Not limited to one dimension
		int[][] intArray4 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] intArray5 = new int[3][4];
		System.out.println(intArray4.toString());
		System.out.println(Arrays.toString(intArray4));
		
		for(int i = 0; i < intArray4.length; i++) {
			for(int j = 0; j < intArray4[i].length; j++) {
				System.out.print(intArray4[i][j] + " ");
			}
			
			System.out.println();
		}
		
		for(int i = 0; i < intArray4.length; i++) {
			System.out.println(Arrays.toString(intArray4[i]));
		}
		
		for(int[] i : intArray4) {
			System.out.println(Arrays.toString(i));
		}
		
		//Throws ArrayIndexOutOfBoundsException
		System.out.println(intArray1[5]);
	}
	
	
	public static void funWithVarargs(String ...a) {
		for (String s : a) {
			System.out.println(s);
		}
	}
}
