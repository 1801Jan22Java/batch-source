package com.revature.homework1;

import java.util.Scanner;
public class Question3 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a word ");
		String myName = kb.next();
		char[] name = myName.toCharArray();
		for(int i=name.length-1;i>=0;i--) {
			System.out.println(name[i]);
		}
		
		
	}

}
