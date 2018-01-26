package com.revature.wednesday;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		
		
		//funWithArrays();
		
		//funWithVarargs();
		//funWithVarargs("cat");
		//funWithVarargs("pot", "kettle");
		
		funWithStrings();
		
	}
	
	public static void funWithHashCodes() {
		String[] members1 = {"Calder", "Kiera", "Chad"};
		Batch b1 = new Batch("1801Jan22", "Java", members1 );
		
		System.out.println(b1.hashCode());
		
		String[] members2 = {"Matt", "Conan", "Sungkwon"};
		Batch b2 = new Batch("1801Jan22", "Java", members2 );
		
		System.out.println(b2.hashCode());
	}
	
	public static void funWithArrays() {
		//ways to declare arrays
		int[] intArr1 = {5, 6, 7};
		int[] intArr2 = new int[7];
		int intArr3[] = new int[7]; // legal but disgusting 
		
		// use the arrays utility class
		// also has sort, search, etc
		//System.out.println(Arrays.toString(intArr1));
		
		int[][] intArr4 = {{1,2,3},{4,5,6},{7,8}};
		int[][] intArr5 = new int [3][4];
		
		for(int i = 0; i < intArr4.length; i++) {
			System.out.println(Arrays.toString(intArr4[i]));
		}
		
		
	}
	
	// varargs
	// method will take a variable number of String arguments
	public static void funWithVarargs(String ...a) {
		//moving through varargs
		for (String s: a) {
			System.out.println(s);
		}
	}
	
	public static void funWithStrings() {
		
		String a = "cow";
		String b = new String("cow");
		
		//System.out.println(a.equals(b));
		
		//StringBuilder reverse
		String str1 = "erutaver";
		StringBuilder sb = new StringBuilder(str1);
		System.out.println(sb.reverse());
		
		// comparing stringBuilders
		StringBuilder sb2 = new StringBuilder("revature");
		
		System.out.println(sb.hashCode());
		System.out.println(sb2.hashCode());
		
		String str6 = "revature";
		String str7 = "revature";
		
		System.out.println(str6.hashCode());
		System.out.println(str7.hashCode());
		
	}
		

}
