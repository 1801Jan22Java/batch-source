package com.revature.wednesday;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		// funWithHashCodeAndEquals()
		
		// funWithArrays();
		
		// funWithVarargs();
		// funWithVarargs("cat");
		// funWithVarargs("cat", "dog", "bird");
		
		funWithStrings();

	}
	
	public static void funWithStrings() {
		
		String a = "cow";
		String b = new String("cow");
		
		System.out.println(a==b); // false
		
		System.out.println(a.equals(b)); // true
		
		// String API methods
		
		// indexof
		String str1 = "indexOfx";
		System.out.println(str1.indexOf('x', 1)); // Starting at index 1
		System.out.println(str1.indexOf('x', 5)); // Starting at index 5
		
		// isEmpty
		String str2 ="empty";
		if ((str2.isEmpty())) {
			System.out.println("String has length zero");
		} else {
			System.out.println("String has length " + str2.length());
		}
		
		// format
		String str3 = "hello";
		System.out.println(String.format("%s world", str3));
		
		// split
		String str4 = "Java-string-split-method";
		String[] words = str4.split("-");
		// Use split(" ") to split on whitespace
		System.out.println(Arrays.toString(words));
		
		/*
		 * Note:
		 * String API contains many more useful methods like concat, contains,
		 * substring, trim, getChars, compareTo, et cetera
		 */
		
		// StringBuilder reverse method
		String str5 = "erutaver";
		StringBuilder sb = new StringBuilder(str5);
		System.out.println(sb.reverse());
		
		// Comparing StringBuilders
		StringBuilder sb2 = new StringBuilder("revature");
		System.out.println(sb.hashCode() + " " + sb2.hashCode());
		System.out.println(sb.equals(sb2));
		
		String str6 = "revature";
		String str7 ="revature";
		System.out.println(str6.hashCode() + " " + str7.hashCode());
		System.out.println(str6.equals(str7));
		
		// Modify sb2's value
		System.out.println(sb2.hashCode());
		StringBuilder sb3 = sb2.append("!");
		System.out.println(sb3.hashCode());
		System.out.println(sb2.equals(sb3));
		
	}
	
	public static void funWithArrays() {
		
		// Ways to declare arrays:
		int[] intArray1 = {1, 2, 3, 4, 5, 6, 7};
		int[] intArray2 = new int[7];
		int intArray3[] = new int[7]; // Legal. Horrible. Confusing.
		
		System.out.println(intArray1.toString());
		System.out.println(Arrays.toString(intArray1));
		
		// Not limited to one dimension
		int[][] intArray4 = {{1, 2, 3}, {4, 5, 6}, {7, 8}};
		int[][] intArray5 = new int[3][4];
		
		System.out.println(intArray4.toString());
		System.out.println(Arrays.toString(intArray4));
		
		for (int[] i : intArray4) { //(int i = 0; i < intArray4.length; i++) {
			/*for (int j = 0; j < intArray4[i].length; j++) {
				System.out.print(intArray4[i][j] + " ");
				System.out.println();
			}*/
			// System.out.println(Arrays.toString(intArray4[i]));
			System.out.println(Arrays.toString(i));
		}
		
		// System.out.println(intArray1[7]); ArrayIndexOutOfBoundsException
		
	}
	
	public static void funWithHashCodeAndEquals() {
		String[] members1 = {"Calder", "Kiera", "Chad"};
		Batch b1 = new Batch("1801Jan22", "Java", members1);
		
		// System.out.println(b1.hashCode());
		
		String[] members2 = {"Matt", "Conan", "Sungkwon"};
		Batch b2 = new Batch("1801Jan22", "Java", members2);
		
		// System.out.println(b2.hashCode());
		
		// System.out.println(b1.equals(b2));
	}
	
	// Varargs
	// method will take a variable number of String arguments
	// Vararg must be the last argument and can be any type
	public static void funWithVarargs(String ...a) {
		// Moving through varargs
		for (String s : a) {
			System.out.println(s);
		}
	}

}
