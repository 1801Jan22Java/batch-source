package com.revature.wednesday;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		String[] members1 = {"Calder","Kiera","Chad"};
		Batch b1 = new Batch("1801Jan22", "Java",members1);
		
		System.out.println(b1.hashCode());
		
		String[] members2 = {"Matt","Conan","Sungkwon"};
		Batch b2 = new Batch("1801Jan22", "Java",members2);
		
		System.out.println(b2.hashCode());
		
		System.out.println(b1.equals(b2));
		
		//funWithArrays();
		//String[] varargs1 = {"cat","dog","bird"};
		//funWithVarargs(varargs1);
		funWithStrings();
	}
	
	public static void funWithArrays() {
		
		//ways to declare arrays
		int[] intArray1 = {5,6,7};
		int[] intArray2 = new int[7];
		int intArray3[] = new int[7]; //legal but horrible
		
		System.out.println(intArray1.toString());
		//use Arrays utility class for useful methods
		//also has a sort, search et cetera...
		System.out.println(Arrays.toString(intArray1));
		
		//not limited to one dimension
		int[][] intArray4 = {{1,2,3},{4,5,6},{7,8}};
		int[][] intArray5 = new int[3][4];
		for (int i = 0; i<intArray4.length; i++) {
			for (int j=0; j<intArray4[i].length; j++) {
				System.out.print(intArray4[i][j]+" ");
			}
		}
		System.out.println();
		for (int i = 0; i<intArray4.length; i++) {
			System.out.println(Arrays.toString(intArray4[i]));
		}
		for(int[] i:intArray4) {
			System.out.println(Arrays.toString(i));
		}
		
	}
	
	//varargs
	//method will take a variable sumber of String arguments
	//vararg must be the last argument
	//can be any type
	public static void funWithVarargs(String ...a) {
		//moving through the varargs
		for (String s : a) {
			System.out.println(s);
		}
	}
	
	public static void funWithStrings() {
		//String API methods
		
		//indexOf
		String str1 = "indexOfX";
		System.out.println(str1.indexOf("X", 5));
		
		//isEmpty
		String str2 = "empty";
		if (str2.isEmpty()) {
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
		for (String w : words) {
			System.out.println(w);
		}
		
		//note:
		//String API contains other useful methods like: concat, contains, substring, trim, getChars, compareTo
		
		//StringBuilder reverse method
		String str5 = "erutaver";
		StringBuilder sb = new StringBuilder(str5);
		System.out.println(sb.reverse());
		
		//comparing StringBuilders
		StringBuilder sb1 = new StringBuilder("revature");
		System.out.println(sb.hashCode());
		System.out.println(sb1.hashCode());
		
	}
}
