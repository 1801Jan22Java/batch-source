package com.revature.homework1;

import java.util.*;
public class Question19 {
	
	private static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public static void evens() {
		int sum = 0;
		for(int i = 1; i < arr.size(); i += 2) {
			sum += arr.get(i);
		}
		
		System.out.println("Sum of even numbers: " + sum);
	}
	
	public static void odds() {
		int sum = 0;
		for(int i = 0; i < arr.size(); i += 2) {
			sum += arr.get(i);
		}
		
		System.out.println("Sum of odd numbers: " + sum);
	}
	
	public static void nonPrime() {
		ArrayList<Integer> nonPrime = new ArrayList<Integer>();
		for (int i = 0; i < arr.size();i++) {
			for(int j = 2; j < i; j++) {
				if (arr.get(i) % j == 0) {
					nonPrime.add(arr.get(i));
					break;
				}
				
			}
		}
		System.out.println(nonPrime.toString());
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			arr.add(i+1);
		}
		System.out.println(arr.toString());
		evens();
		odds();
		nonPrime();
	}
	
	
}
