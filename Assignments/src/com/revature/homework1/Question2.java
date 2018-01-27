package com.revature.homework1;

import java.util.*;

/*
 * get the first 25 fibonacci numbers using memoization (.o.) - sugoi!
 */

public class Question2 {
	// initalize the array to all zeros
	private static int mem []= new int[100];
	
	// make los table - runtime is O(n)
	private static void memoize() {
		mem[0] = 0;
		mem[1] = 1;
		// create the table entries for the first 25 numbers
		for (int i = 2; i < 100; i ++ ) {
			mem[i] = mem[i-1] + mem[i - 2];
		}
	}
	
	public static void main(String[] args) {
		memoize();
		System.out.println(Arrays.toString(mem));
		
	}

}
