package com.revature.homework1;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {

		//QUESTION 1
		System.out.print("Question 1 Output: ");
		int[] nums = new int[] {10, 2, 4, 23, 54, 7, 4, 6, 8, 1, 23, 53};
		nums = Question1.bubbleSort(nums);
		for(int i = 0; i < nums.length; i++)
			System.out.print(nums[i]+ "   ");

		//QUESTION 2
		System.out.println(System.lineSeparator()+System.lineSeparator()+"Question 2 Output: ");
		for(int i = 1; i <= 25; i++)
			System.out.print(Question2.fibonacci(i)+"   ");

		//QUESTION 3
		System.out.println(System.lineSeparator()+System.lineSeparator()+"Question 3 Output:");
		System.out.println("Word before reversing: iridescent");
		System.out.println("Word after reversing: " + Question3.reverse("iridescent"));

		//QUESTION 4
		System.out.print(System.lineSeparator()+"Question 4 Output: ");
		System.out.println(Question4.nFactorial(6));

		//QUESTION 5
		System.out.print(System.lineSeparator()+"Question 5 Output: ");
		System.out.println(Question5.substring("Faith,_Hope,_Love", 7));

		//QUESTION 6
		System.out.println(System.lineSeparator()+"Question 6 Output: ");
		System.out.println("Testing for odd number: "+Question6.isEven(7));
		System.out.println("Testing for odd number: "+Question6.isEven(6));

		//QUESTION 7
		System.out.println(System.lineSeparator()+"Question 7 Output: ");
		Question7.sortEmployees();
		
		//QUESTION 8 - Needs Work
		System.out.println(System.lineSeparator()+"Question 8 Output: ");
		//Question8.wordsAndTheirPalindromes();

		//QUESTION 9
		System.out.println(System.lineSeparator()+"Question 9 Output: ");
		System.out.println(Arrays.toString(Question9.primes1To100().toArray()));

		//QUESTION 10
		System.out.println(System.lineSeparator()+"Question 10 Output: ");
		System.out.println(Question10.minimum(5, 6));

		//QUESTION 11 - Needs Work
		System.out.println(System.lineSeparator()+"Question 11 Output: ");

		//QUESTION 12
		System.out.println(System.lineSeparator()+"Question 12 Output: ");
		Question12.storeAndManipulate1To100();

		//QUESTION 13
		System.out.println(System.lineSeparator()+System.lineSeparator()+"Question 13 Output: ");
		Question13.displayNumTriangle();

		//QUESTION 14
		System.out.println(System.lineSeparator()+"Question 14 Output: ");
		Question14.switchExample();

		//QUESTION 15 - Needs Work
		System.out.println(System.lineSeparator()+"Question 15 Output: ");
		//System.out.println(Implementor.addition(5, 8);
		//System.out.println(Implementor.subtract(5, 8);

		//QUESTION 16 - Needs Work
		System.out.println(System.lineSeparator()+"Question 16 Output: ");
		//System.out.println(Question16.length(args[0]));

		//QUESTION 17
		System.out.println(System.lineSeparator()+"Question 17 Output: ");
		Question17.printPrincipal();

		//QUESTION 18 - Needs Work
		System.out.println(System.lineSeparator()+"Question 18 Output: ");

		//QUESTION 19
		System.out.println(System.lineSeparator()+"Question 19 Output: ");
		Question19.question19();
		
		//QUESTION 20 - Needs Work
		System.out.println(System.lineSeparator()+"Question 20 Output: ");
	}

}
