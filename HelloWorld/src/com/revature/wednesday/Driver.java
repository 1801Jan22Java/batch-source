package com.revature.wednesday;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
	}
	
	public static void funWithHashcode()
		{
			
		// TODO Auto-generated method stub
		
		String[] members1 = {"Calder", "Keira", "Chad"};
		Batch b1 = new Batch("1801Jan22", "Java", members1);
		System.out.println(b1.hashCode());
		
		String[] members2 = {"Matt", "Conan", "Sunkwon"};
		Batch b2 = new Batch("1801Jan23", "Java", members2);
		System.out.println(b2.hashCode());
		
		//funWithArrays();
		String[] vargargs1 = {"cat"};
		funWithVarargs("cat");
		funWithVarargs("cat, dog, bird");
		

	}
	
	public static void funWithStrings()
	{
		String a = "cow";
		String b = new String("cow");
		
		System.out.println(a==b);
		
		System.out.println(a.equals(b));
		
		String str1 = "Indexofx";
		System.out.println(str1.indexOf('x', 5));
		
		String str2 = "empty";
		if (str2.isEmpty())
		{
			System.out.println("string has length zero");
		}
		else
		{
			
		}
		
		String str5 = "erutaver";
		StringBuilder sb = new Stringbuilder()
		
	}
	public static void funWithArrays() {
		int[] intArray1 = {5,6,7};
		int[] intArray2 = new int[7];
		int intArray3[] = new int[7]; 	//legal but terrible
		
		System.out.println(intArray1.toString());
		System.out.println(Arrays.toString(intArray1));
		
		int[][] intArray4 = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[][] intArray5 = new int[3][4];
		
		System.out.println(intArray4.toString());
		
		for(int i =0; i<intArray4.length; i++)
		{
			for(int j =0; j<intArray4[1].length; j++)
			{
				System.out.println(intArray4[i][j]);
			}
		}
		// throws ArrayIndexOutOfBounds exception
		System.out.println(intArray1[5]);
	}
	
	//varargs
	//method will take a variable number of String arguments
	//varargs must be the last argument
	public static void funWithVarargs(String ...a)
	{
		for( String s :a) {
			System.out.println(s);
		}
	}

}
