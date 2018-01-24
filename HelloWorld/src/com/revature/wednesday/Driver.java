package com.revature.wednesday;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		//funWithHashCodes()
		
		//funWithArrays();
		
		/*
		funWithVarargs();
		funWithVarargs("cat");
		funWithVarargs("cat", "dog", "bird");
		*/
		
		funWithStrings();
		
	}
	
	public static void funWithStrings() {
		String a = "cow";
		String b = new String("cow");
		
		//what is this?? false
		System.out.println(a==b);
		
		//what is it?? true
		System.out.println(a.equals(b));
		
		//String API methods
		
		//indexOf
		String str1 = "indexOfx";
		System.out.println(str1.indexOf('x', 1));
		System.out.println(str1.indexOf('x', 5));
		
		//isEmpty
		String str2 = "empty";
		if(str2.isEmpty()) {
			System.out.println("string has length 0");
		}else {
			System.out.println("string has length " + str2.length());
		}
		
		//format
		String str3 = "hello";
		System.out.println(String.format("%s world", str3));
		
		//split
		String str4 =  "java-string-split-method";
		String[] words = str4.split("-");
		System.out.println(Arrays.toString(words));
		//use .split(" ") to split on white space
		
		/*
		 * note:
		 * String api also contains other useful methods like
		 * concat,
		 * contains,
		 * substring,
		 * trim,
		 * getChars
		 * compareTo, ....
		 */
		
		//StringBuilder reverse method
		String str5 = "erutaver";
		StringBuilder sb = new StringBuilder(str5);
		System.out.println(sb.reverse());
		
		//comparing String builders
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
		
		
	}
	
	public static void funWithHashCodes() {
		String[] members1 = {"Calder", "Kiera", "Chad"};
		Batch b1 = new Batch("1801Jan22", "Java", members1);
		
		System.out.println(b1.hashCode());
		
		String[] members2 = {"Matt", "Conan", "Sungkwon"};
		Batch b2 = new Batch("1801Jan22", "Java", members2);
		
		System.out.println(b2.hashCode());
		
		System.out.println(b1.equals(b2));
	}
	
	public static void funWithArrays() {
		//ways to declare arrays
		int[] intArray1 = {5,6,7};
		int[] intArray2 = new int[7];
		int intArray3[] = new int[7];//legal but horrible
		
		System.out.println(intArray1.toString());
		//Use the arrays utility class for useful methods
		//also has sort search etc...
		System.out.println(Arrays.toString(intArray1));
		
		//not limited to one dimension
		int[][] intArray4 = {{1,2,3}, {4,5,6}, {7,8}};
		int[][] intArray5 = new int[3][4];
		System.out.println(intArray4.toString());
		System.out.println(Arrays.toString(intArray4));
		
		for (int i = 0; i < intArray4.length; i++) {
			/*for (int j = 0; j <intArray4[i].length; j++) {
				System.out.print(intArray4[i][j] + " ");
			}*/
			System.out.println(Arrays.toString(intArray4[i]));
		}
		
		for (int[] i : intArray4) {
			/*for (int j = 0; j <intArray4[i].length; j++) {
				System.out.print(intArray4[i][j] + " ");
			}*/
			System.out.println(Arrays.toString(i));
		}
		
		//throws ArrayIndexOutOfBounds exception
		System.out.println(intArray1[5]);
	}

	//vararg
	//method will take a variable number of String arguments
	//vararg must be last argument
	//can be any type
	public static void funWithVarargs(String ...a) {
		//moves through the varargs
		for (String str : a) {
			System.out.println(str);
		}
	}

}
