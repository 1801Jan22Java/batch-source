package com.revature.homework1;

import java.util.Scanner;
public class Question16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String name = kb.next();
		if(name.length() == 4) {
			System.out.println(name.length());
		}
		else {
			System.out.println("Invalid");
		}

	}

}
