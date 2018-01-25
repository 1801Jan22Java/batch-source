package com.revature.wednesday;

import java.util.Arrays;

public class Driver {

	public static void main(String [] args)
	{
		
	//	funWithArrays();
	//	String [] varargs1 = {"cat"};
	//	funWithVarargs(varargs1);
	//	funWithVarargs("rush","styx","yes");
		funWithStrings();
	}
	
	
	public static void funWithStrings()
	{
		String a = "Cow";
		String b= new String("Cow");
		
		
		System.out.println(a==b); //Returns false - Comparing the objects
		System.out.println(a.equals(b)); //Returns true - Comparing the string literal
		
		// String API methods
		
		String str1= "indexOfx";
		System.out.println(str1.indexOf('x',5));
		
		//isEmpty
		String str2="empty";
		if(str2.isEmpty())
		{
			System.out.println("String has length 0");
		}
		else 
			System.out.println("String has length " + str2.length());
		
		// format
		
		String str3= "Hello";
		System.out.println(String.format("%s world",str3));
		
		//split
		String str4 = "John-jacob-jingleheimer-schmidt";
		String [] words = str4.split("-");
		//You can use .split(" ") to split on whitespace
		System.out.println(Arrays.toString(words));
		for(String w : words)
		{
			System.out.println(w);
		}
		
		/*
		 * note: string API also contains many other useful methods
		 * i.e. concat(), contains(), substring(),trim(), getChars()
		 * compareTo(), et cetera
		 * */
		
		//StringBuilder
		
		String str5 = "erutaver";
		
		//StringBuilder reverse method
		StringBuilder sb= new StringBuilder(str5).reverse();
		System.out.println(sb);
		
		//Comparing StringBuilders
		StringBuilder sb2=  new StringBuilder("revature");
		System.out.println(sb2.hashCode());
		System.out.println(sb.hashCode());
		System.out.println(sb.equals(sb2));
		
		String str6 = "eventyr";
		String str7 = "eventyr";
		System.out.println(str6.hashCode() + " " +str7.hashCode());
		//StringBuffer
		
		//modify sb2's value
		System.out.println(sb2.hashCode());
		StringBuilder sb3= sb2.append("!");
		System.out.println(sb3.hashCode());
		System.out.println(sb2.equals(sb3));
		
		
		
		
	}
	
	public static void funWithHashCodeAndEquals(){
		String [] members1= {"Calder","Kiera","Chad"};
		Batch b1 = new Batch("1801Jan22", "Java", members1);
		String [] members2 = {"Matt","Conan","Sungkwon"};
		Batch b2 = new Batch("1801Jan22", "Java", members2);
		
		
		System.out.println(b1.hashCode());
		System.out.println(b2.hashCode());
		System.out.println(b1.equals(b2));
		
	}
	public static void funWithArrays()
	{
		int [] intArray1= {5,6,7};
		int [] intArray2 = new int[7];
		int intArray3 [] = new int[5];  // legal but DISCOURAGED.  
		
		System.out.println(intArray1.toString() + " " + intArray2.toString());
		System.out.println(Arrays.toString(intArray1) + "  " + Arrays.toString(intArray2));
		
		// not limited to one dimension
		
		int [][] intArray4 = {{1,2,3},{4,5,6},{7,8,9}};
		int [][] intArray5 = new int [3][4];
		System.out.println(Arrays.toString(intArray4));
		
		for (int [] a : intArray4)
		{
		//	System.out.print("{");
			for(int b : a)
			{
				//System.out.print(b+",");
			
			}
			//System.out.print("},");
			System.out.println(Arrays.toString(a));
			
		}
		//Throws exception
		System.out.println(intArray1[5]);
		
		
	}

	
	//varargs
	//method will take a variable number of strings
	//vararg must be the last argument
	//can be any type
	public static void funWithVarargs(String ...a)
	{
		//moving through the varargs
		for(String s : a)
		{
			System.out.println(s);
		}
	}
}
