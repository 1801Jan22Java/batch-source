package com.revature.homework1;

public class Question5 {

	public static void substringCity(String str, int idx) {
		for(int i=0; i<idx; i++) {
			System.out.print(str.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		
		substringCity("Utahhhh", 4);
	}
}
