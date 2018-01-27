package com.revature.homework1;

import java.util.*;

public class Question4 {
	
	private static ArrayList<Integer> table = new ArrayList<Integer>();
	
	// fill out the first two using a code block (.o.)
	static {
	table.add(1);
	table.add(1);
	}
	
	// use a table?
	public static int factorial(int n) {
		
		// the first two should already be in the table
		if (n < 2) {
			return table.get(n);
		}
		
		// for everything else use a table so you dont have to repeat caclulations
		int size = table.size();
		for (int i = size; i <= n; i++) {
			//System.out.println(i);
			table.add(i*table.get(i-1));
			
		}
		
		// return the value you just calculated
		return table.get(n);
	}
	
	public static void main(String[] args) {
		
		//System.out.println(table.toString());
		System.out.println(factorial(10));
		System.out.println(table.toString());
		
	}

}
