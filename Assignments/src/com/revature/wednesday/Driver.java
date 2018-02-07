package com.revature.wednesday;

import java.util.Arrays;

public class Driver {
	
	public static void main(String[] args) {
		
//		String[] members1 = {"Calder","Kiera","Chad"};
//		Batch b1 = new Batch("1801Jan22","Java",members1);
//		
//		System.out.println(b1.hashCode());
//		
//		String[] members2 = {"Matt","Conan","Sungkwon"};
//		Batch b2 = new Batch("1801Jan23","Java",members2);
//		
//		System.out.println(b2.hashCode());
//		
//		funWithVarArgs("h","e","l","l","o");
		
		funWithStrings();
	}
	
	public static void funWithArrays() {
		// ways to declare arrays
		int [] intArray1 = {5,6,7};
		int [] intArray2 = new int[7];
		int intArray3 [] = new int[12];
		
		System.out.println(intArray1.toString());
		// use the arrays utility class for useful methods
		// also has sort, search, etc.
		System.out.println(Arrays.toString(intArray1));
		
		//not limited to one dimension
		int [][] intArray4 = {{1,2,3},{4,5,6},{7,8,9}};
		int [][] intArray5 = new int[3][4];
		System.out.println(intArray4.toString());
		System.out.println(Arrays.toString(intArray4));
		
		for(int i = 0; i<intArray4.length; i++) {
			for(int j = 0; j < intArray4[i].length;j++) {
				System.out.println(intArray4[i][j]);
			}
		}
		
		
	}
	
	//varargs
	//method will take a variable number of String arguments
	//vararg must be the last argument
	//can be of any type
	public static void funWithVarArgs(String ...a) {
		
		//moving through the varargs
		
		for (String s: a) {
			System.out.println(s);
		}
		
	}
	
	public static void funWithStrings() {
		
		String a = "cow";
		String  b = new String("cow");
		
		//false
		System.out.print("eek ");
		System.out.println(a==b);
		
		//true
		System.out.println("equals " + a.equals(b));
		
		String str1 = "indexOfx";
		System.out.println(str1.indexOf('x',5));
		
		//isEmpty
		String str2 = "empty";
		 if (str2.isEmpty()) {
			 System.out.println("empty");
		 }
		 else {
			 System.out.println("not empty");
		 }
		 
		 //format
		 String str3 = "hello";
		 System.out.println(String.format("%s world", str3));
		 
		 //split
		 String str4 = "java-string-split-method";
		 String[] words = str4.split("-");
		 for(String w: words) {
			 System.out.println(w);
		 }
	
		 
		 /*
		  * note:
		  * String API also contains other useful methods like
		  * concat, contains, substring, trim, getChars
		  */
		 
		 //StringBuilder
		 String str5 = "revature";
		 StringBuilder sb = new StringBuilder(str5);
		 System.out.println(sb.reverse());
		 
		 //comparing StringBuilders
		 StringBuilder sb2 = new StringBuilder("revature");
		 System.out.println(sb.hashCode());
		 System.out.println(sb2.hashCode());
		 
	}

}
