package com.revature.homework1;
import java.lang.Math;

import java.time.LocalDateTime;


public class Question14 {

	public static void main(String[] args) {
		
	
		double x = 64;
		String functionality = "display date";
		String learnJava;
		// decides which case to excecute depending on string
		switch (functionality) {
		case "square root":
				x = Math.sqrt(x);
				System.out.println(x);
				break;
		case  "display date":
				System.out.println(LocalDateTime.now());
				break;
		case  "split string":
				learnJava = "I am learning Core Java";
				String[] parts = learnJava.split(" ");
				System.out.println(parts[0]);
				System.out.println(parts[1]);
				System.out.println(parts[4]);
				break;
				
	
				
				
		
		}

	}

}
