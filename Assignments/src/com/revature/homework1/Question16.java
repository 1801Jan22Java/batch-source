package com.revature.homework1;

import java.util.Arrays;

public class Question16 {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		if (args.length > 1) {
			System.out.println("Length of first string is " + args[1].length());
			
		}
		else {
			System.out.println("no argument given");
		}
	}

}
