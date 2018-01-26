package com.revature.wed;

import java.util.Arrays;

public class Driver {
	public static void main(String[] args) {
		String[] members1 = {"Calder", "Kiera", "Chad", "Eric"};
		Batch b1 = new Batch("1801Jan22", "Java", members1 );
		System.out.println(b1.hashCode());
		
		String[] members2 = {"Calvin", "Josh", "Chad", "Eric"};
		Batch b2 = new Batch("1801Jan22", "Java", members2 );
		System.out.println(b2.hashCode());
		
		funWithStrings();
	}
	
	public static void funWithStrings() {
		String a = "cow";
		String b = new String("cow");
		System.out.println(a==b);
		System.out.println(a.equals(b));
		
		String str1 = "indexOf";
		System.out.println(String.format("%s world", str1));
		
		String str4 = "java-string-split-method";
		String[] words = str4.split("-");
		for (String x : words) { System.out.println(x); }
		
		String str5 = "erutaver";
		StringBuilder sb = new StringBuilder(str5);
		System.out.println(sb.reverse());
		
		StringBuilder sb2 = new StringBuilder("revature");
		System.out.println(sb.hashCode());
		System.out.println(sb2.hashCode());
		
		String str6 = "revature";
		String str7 = "revature";
		System.out.println(str6.hashCode());
		System.out.println(str7.hashCode());
		
		System.out.println(sb.equals(sb2));
		sb2.append("1");
	}
	
	public static void funWithArrays() {
		int[] intArray1 = {5,6,7};
		int[] intArray2 = new int[7];
		System.out.println(intArray1.toString());
		System.out.println(Arrays.toString(intArray1));
		
		
	}
	
	public static void funWithVarArgs(String ...a) {
		
	}
}
