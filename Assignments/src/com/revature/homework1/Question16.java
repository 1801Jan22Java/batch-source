package com.revature.homework1;

public class Question16 {
	public static void main(String[] args) {
		// for each argument passed from the command line
		for (int i = 0; i < args.length; i++) {
			// print the length of the string
			System.out.println("length of \"" + args[i] + "\" = " + args[i].length());
		}
		System.out.print("\n");
	}

}
