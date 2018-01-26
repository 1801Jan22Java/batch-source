package com.revature.wednesday;

import java.util.Arrays;

public class Driver {
<<<<<<< HEAD
	public static void main(String[] args) {
//		
//		String[] members1 = {"Calder", "Kiera", "Chad"};
//		Batch b1 = new Batch("1801Jan22","Java", members1);
//		
//		System.out.println(b1.hashCode());
//		
//		String[] members2 = {"Matt", "Conan", "Sungkwon"};
//		Batch b2 = new Batch("1801Jan22","Java", members2);
//		
//		System.out.println(b2.hashCode());
//		System.out.println(b1.equals(b2));
		
		//funWithArrays();
		/*
		funWithVarargs();
		funWithVarargs("cat");
		funWithVarargs("cat","dog","bird");
		*/
		
		funWithStrings();
	}
	
	public static void funWithStrings() {
=======

	public static void main(String[] args) {

		// funWithArrays();

		/*
		 * funWithVarargs(); funWithVarargs("cat");
		 * funWithVarargs("cat","dog","bird");
		 */
		
		funWithStrings();
		
	}
	
	public static void funWithStrings(){
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
		
		String a = "cow";
		String b = new String("cow");
		
<<<<<<< HEAD
		System.out.println(a==b);
		// False: They're 2 different objects entirely
		
		System.out.println(a.equals(b));
		// True: .equals() compares the content, the String literal
		
		// String API methods
		
		// indexOf()
		String str1 = "indexOfx";
		System.out.println(str1.indexOf('x',5));
		
		// isEmpty()
		String str2 = "empty";
		if(str2.isEmpty()) {
			System.out.println("String has length 0.");
		} else {
			System.out.println("String has length "+str2.length());
		}
		
		// format()
		String str3 = "hello";
		System.out.println(String.format("%s world", str3));
		
		// split()
		// use .split(" ") to split on whitespace
		String str4 = "java-string-split-method";
		String [] words = str4.split("-");
		System.out.println(Arrays.toString(words));
		
		/*
		 * note:
		 * String API has much more like
		 * concat(), contains(), substring(), trim(),getChars(),
		 * compareTo()
		 * 
		 */
		
		
		// StringBuilder
=======
		//false
		System.out.println(a==b);
		
		//true 
		System.out.println(a.equals(b));
		
		//String API methods
		
		//indexOf
		String str1 = "indexOfx";
		System.out.println(str1.indexOf('x',5));
		
		//isEmpty
		String str2 = "empty";
		if(str2.isEmpty()){
			System.out.println("string has length zero");
		} else {
			System.out.println("string has length "+str2.length());
		}
		
		//format
		String str3 = "hello";
		System.out.println(String.format("%s world", str3));
		
		//split
		String str4 = "java-string-split-method";
		String[] words = str4.split("-");
		//use .split(" ") to split on whitespace
		for (String w : words){
			System.out.println(w);
		}
		
		/*
		 * note:
		 * String API also contains other useful methods like
		 * concat, contains, substring, trim, getChars
		 * compareTo, et cetera
		 */
		
		//StringBuilder reverse method 
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
		String str5 = "erutaver";
		StringBuilder sb = new StringBuilder(str5);
		System.out.println(sb.reverse());
		
<<<<<<< HEAD
		// comparing StringBuilders
=======
		//comparing StringBuilders
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
		StringBuilder sb2 = new StringBuilder("revature");
		System.out.println(sb.hashCode());
		System.out.println(sb2.hashCode());
		System.out.println(sb.equals(sb2));
		
		String str6 = "revature";
		String str7 = "revature";
		System.out.println(str6.hashCode());
		System.out.println(str7.hashCode());
		
<<<<<<< HEAD
		// modify sb2's value
		System.out.println(sb2.hashCode());
		StringBuilder sb3 = sb2.append("!");
		System.out.println(sb3.equals(sb2));
	}
		
	
	public static void funWithArrays() {
		
		// Ways to declare arrays
		int[] intArray1 = {5,6,7};
		int[] intArray2 = new int[7];
		
		// Don't do this, it's legal but horribad
		int intArray3[] = new int[7];
		
		System.out.println(intArray1.toString());
		System.out.println(Arrays.toString(intArray1));
		// Arrays utility also has sort, search, etc
		
		// not limited to one dimension
		int[][] intArray4 = {{1,2,3},{4,5,6},{7,8}};
		int[][] intArray5 = new int[3][4];
		
		System.out.println(intArray4.toString());
		System.out.println(Arrays.toString(intArray4));
		
		/*for(int i=0; i<intArray4.length; i++) {
		
		*/
		for(int[] i : intArray4) {
			/*for(int j=0; j<intArray4[i].length; j++) {
				System.out.print(intArray4[i][j]+" ");
			}
			*/
			System.out.println(Arrays.toString(i));
		}
		
		System.out.println(intArray1);
		

		
	}
	
	// Var args
	// method will take in a variable # of arguments
	// Must be last argument
	// Can be any type
	public static void funWithVarargs(String ...a) {
		// moving through the varargs
		for(String string : a) {
			System.out.println(string);
		}
		
	}
=======
		//modify sb2's value
		System.out.println(sb2.hashCode());
		StringBuilder sb3 = sb2.append("!");
		System.out.println(sb3.hashCode());
		System.out.println(sb2.equals(sb3));
		
		
		
	}

	public static void funWithHashCodeAndEquals() {
		String[] members1 = { "Calder", "Kiera", "Chad" };
		Batch b1 = new Batch("1801Jan22", "Java", members1);

		System.out.println(b1.hashCode());

		String[] members2 = { "Matt", "Conan", "Sungkwon" };
		Batch b2 = new Batch("1801Jan22", "Java", members2);

		System.out.println(b2.hashCode());

		System.out.println(b1.equals(b2));
	}

	public static void funWithArrays() {

		// ways to declare arrays
		int[] intArray1 = { 5, 6, 7 };
		int[] intArray2 = new int[7];
		int intArray3[] = new int[7]; // legal but horrible

		System.out.println(intArray1.toString());
		// use the Arrays utility class for useful methods
		// also has a sort, search, et cetera...
		System.out.println(Arrays.toString(intArray1));

		// not limited to one dimension
		int[][] intArray4 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8 } };
		int[][] intArray5 = new int[3][4];
		System.out.println(intArray4.toString());
		System.out.println(Arrays.toString(intArray4));

		for (int[] i : intArray4) {// int i=0; i<intArray4.length; i++){

			/*
			 * for (int j=0;j<intArray4[i].length; j++){
			 * System.out.print(intArray4[i][j]+" "); }
			 */
			System.out.println(Arrays.toString(i));
			System.out.println();
		}

		// throws ArrayIndexOutOfBounds exception
		System.out.println(intArray1[5]);

	}

	// varargs
	// method will take a variable number of String arguments
	// vararg must be the last argument
	// can be any type
	public static void funWithVarargs(String... a) {
		// moving through the varargs
		for (String s : a) {
			System.out.println(s);
		}
	}

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}
