package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Driver {

	public static void main(String[] args) {

		// Question1 Driver
		int[] anArrayQ1 = { 1, 0, 5, 6, 3, 4, 3, 7, 8, 8, 4 };
		anArrayQ1 = Question1.bubbleSort(anArrayQ1);
		System.out.println("Question 1 results:");
		System.out.println(Arrays.toString(anArrayQ1) + "\n");

		// Question2 Driver
		int[] anArrayQ2 = Question2.fibonacciGen(25);
		System.out.println("Question 2 results:");
		System.out.println(Arrays.toString(anArrayQ2) + "\n");

		// Question3 Driver
		String stringQ3 = "DAOTONPYH EHT OT YROLG LLA";
		System.out.println("Question 3 input : " + stringQ3);
		System.out.println("Question 3 output: " + Question3.stringReverser(stringQ3) + "\n");

		// Question4 Driver
		System.out.println("Question 4 example: 10! = " + Question4.factorializer(10) + "\n");

		// Question5 Driver
		String stringQ5 = "Hello World";
		System.out.println("Question 5 example: ");
		System.out.println("first 5 letters in \"" + stringQ5 + "\": \"" + Question5.substring(stringQ5, 5) + "\"\n");

		// Question6 Driver
		System.out.println("Question 6 example:");
		System.out.println("the number 4 is " + Question6.isEven(4));
		System.out.println("the number 5 is " + Question6.isEven(5) + "\n");

		// Question7 Driver
		// creates Employee objects and adds to an ArrayList
		ArrayList<Question7.Employee> anArrayQ7 = new ArrayList<Question7.Employee>();
		anArrayQ7.add(new Question7.Employee("Bob", "Management", 52));
		anArrayQ7.add(new Question7.Employee("Liz", "Marketing", 45));
		anArrayQ7.add(new Question7.Employee("Evan", "Trainee", 25));
		anArrayQ7.add(new Question7.Employee("Sammy", "Accounting", 45));
		// prints unmodified list
		System.out.println("Question 7 example:");
		System.out.println("Without Sorting: " + anArrayQ7.toString());
		// runs various comparators and displays modified ArrayList
		Collections.sort(anArrayQ7, new Question7.SortByName());
		System.out.println("Sorted by Name:  " + anArrayQ7.toString());
		Collections.sort(anArrayQ7, new Question7.SortByDepartment());
		System.out.println("By Department:   " + anArrayQ7.toString());
		Collections.sort(anArrayQ7, new Question7.SortByAge());
		System.out.println("Sorted by Age:   " + anArrayQ7.toString() + "\n");

		// Question8 Driver
		ArrayList<String> anArrayQ8 = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar",
				"jimmy", "kayak", "john", "refer", "billy", "did"));
		System.out.println("Question 8 example:");
		System.out.println("Full list  : " + anArrayQ8.toString());
		System.out.println("Palindromes: " + Question8.palindromes(anArrayQ8).toString() + "\n");

		// Question9 Driver
		System.out.println("Question 9 results:");
		System.out.println("prime numbers up to 100: " + Question9.primesUpTo(100).toString() + "\n");

		// Question10 Driver
		System.out.println("Question 10 results:");
		System.out.println("The minimum of 5.0 and 10.5 is " + Question10.minimum(5.0, 10.5) + "\n");

		// Question11 Driver
		System.out.println("Question 11 results:");
		Question11.accessExternalVariable();

		// Question12 Driver
		System.out.println("Question 12 results:");
		System.out.println(Arrays.toString(Question12.primesUpTo(100)) + "\n");

		// Question13 Driver
		System.out.println("Question 13 results:");
		Question13.binaryTriforce(4);

		// Question14 Driver
		System.out.println("Question 14 results:");
		System.out.println("sqrt of 25.0 = " + Question14.switcher(1, 25.0));
		System.out.println("today's date = " + Question14.switcher(2));
		System.out.println("split string = " + Question14.switcher(3) + "\n");

		// Question15 Driver
		Question15 numbers = new Question15(15.0, 5.0);
		System.out.println("Question 15 example:");
		System.out.println("15.0 * 5.0 = " + numbers.multiplication());
		System.out.println("15.0 / 5.0 = " + numbers.division() + "\n");

		// Question16 Driver
		System.out.println("Question 16 example:");
		String[] anArrayQ16 = { "Revature", "Hypnotoad", "Evan" };
		Question16.main(anArrayQ16);

		 // Question 17 Driver System.out.println("Question 17 operation:");
		 Question17.calculateSimpleInterest();

		// Question 18 Driver
		System.out.println("Question 18 example:");
		// creates a Question18 object containing a string
		Question18 stringQ18 = new Question18("String with upperCase");
		System.out.println("Does \"" + stringQ18.contents + "\" contain an upperCase = " + stringQ18.hasUpper());
		System.out.println("\"" + stringQ18.contents + "\" converted to upperCase = " + stringQ18.toUpper());
		// creates a Question18 object containing an integer
		Question18 intQ18 = new Question18("101");
		intQ18.add10();
		
		//Question 19 Driver
		System.out.println("Question 19 results:");
		Question19.funWithArrayList();
		
		//Question 20 Driver
		System.out.println("Question 20 results:");
		Question20.readTheData();
	}
}
