package com.revature.hello;
import java.util.Scanner;

public class NumberMachine {

	 public static void main(String[] args)
	    {
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Please enter calculation with spaces between numbers and operators:");
		 String input = sc.nextLine();
		 String[] mathStuff = input.split(" ");
		 double a = Double.parseDouble(mathStuff[0]);
		 double b = Double.parseDouble(mathStuff[2]);
		 
		 switch (mathStuff[1]) {
		 case "+":
			 System.out.println((a+b));
			 break;
		 case "-":
			 System.out.println((a-b));
			 break;
		 case "/":
			 System.out.println((a/b));
			 break;
		 case "*":
			 System.out.println((a*b));
			 break;
		 case "%":
		 	 System.out.println((a%b));
		 	 break;
		 default:
			 System.out.println("Thats not a valid operation.");
		 }			 
	    }
}
