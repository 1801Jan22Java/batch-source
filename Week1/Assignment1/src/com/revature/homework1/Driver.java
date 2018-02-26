package com.revature.homework1;

import java.util.Arrays;

/**
 * 
 * @author CarpizoE
 *
 */
public class Driver {

	public static void main(String[] args) {

		//QUESTION 1
		System.out.print("QUESTION 1 OUTPUT: ");
		int[] nums = new int[] {10, 2, 4, 23, 54, 7, 4, 6, 8, 1, 23, 53};
		nums = Question1.bubbleSort(nums);
		for(int i = 0; i < nums.length; i++)
			System.out.print(nums[i]+ "   ");

		//QUESTION 2
		System.out.println(System.lineSeparator()+System.lineSeparator()+"QUESTION 2 OUTPUT: ");
		for(int i = 1; i <= 25; i++)
			System.out.print(Question2.fibonacci(i)+" ");

		//QUESTION 3
		System.out.println(System.lineSeparator()+System.lineSeparator()+"QUESTION 3 OUTPUT:");
		System.out.println("Word before reversing: iridescent");
		System.out.println("Word after reversing: " + Question3.reverse("iridescent"));

		//QUESTION 4
		System.out.print(System.lineSeparator()+"QUESTION 4 OUTPUT: ");
		System.out.println(Question4.nFactorial(6));

		//QUESTION 5
		System.out.print(System.lineSeparator()+"QUESTION 5 OUTPUT: ");
		System.out.println(Question5.substring("Faith,_Hope,_Love", 7));

		//QUESTION 6
		System.out.println(System.lineSeparator()+"QUESTION 6 OUTPUT: ");
		System.out.println("Testing if \'7\' is an even number: "+Question6.isEven(7));
		System.out.println("Testing if \'6\' is an even number: "+Question6.isEven(6));

		//QUESTION 7
		System.out.println(System.lineSeparator()+"QUESTION 7 OUTPUT: ");
		Question7.sortEmployees();
		
		//QUESTION 8
		System.out.println(System.lineSeparator()+"QUESTION 8 OUTPUT: ");
		Question8.wordsAndTheirPalindromes();

		//QUESTION 9
		System.out.println(System.lineSeparator()+"QUESTION 9 OUTPUT:");
		System.out.println(Arrays.toString(Question9.primes1To100().toArray()));

		//QUESTION 10
		System.out.println(System.lineSeparator()+"QUESTION 10 OUTPUT: ");
		System.out.println("Testing the minimum of \'5\' and \'6\': "+Question10.minimum(5, 6));
		System.out.println("Testing the minimum of \'7\' and \'3\': "+Question10.minimum(7, 3));

		//QUESTION 11
		System.out.println(System.lineSeparator()+"QUESTION 11 OUTPUT: ");
		Question11.printFloats();

		//QUESTION 12
		System.out.println(System.lineSeparator()+"QUESTION 12 OUTPUT:");
		Question12.storeAndPrintEvens();

		//QUESTION 13
		System.out.println(System.lineSeparator()+System.lineSeparator()+"QUESTION 13 OUTPUT: ");
		Question13.displayNumTriangle();

		//QUESTION 14
		System.out.print(System.lineSeparator()+"QUESTION 14 OUTPUT: ");
		Question14.switchExample();

		//QUESTION 15
		System.out.println(System.lineSeparator()+"QUESTION 15 OUTPUT: ");
		Question15.printOperands();

		//QUESTION 16
		//compile by: > javac CommandLineExample.java  
		//run by: > java CommandLineExample thisIsAnArgument
		System.out.println(System.lineSeparator()+"QUESTION 16 OUTPUT: ");
		for(String s : args)
			System.out.println(Question16.length(s));

		//QUESTION 17
		System.out.println(System.lineSeparator()+"QUESTION 17 OUTPUT: ");
		Question17.printPrincipal();

		//QUESTION 18
		System.out.println(System.lineSeparator()+"QUESTION 18 OUTPUT:");
		Question18.printMethods();
		
		//QUESTION 19
		System.out.println(System.lineSeparator()+"QUESTION 19 OUTPUT:");
		Question19.question19();
		
		//QUESTION 20
		System.out.println(System.lineSeparator()+"QUESTION 20 OUTPUT:");
		Question20.readAndPrintFile();
	}

}
