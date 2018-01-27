package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
		//Question1
		System.out.println("QUESTION 1");
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		Question1.isSorted(array);
		System.out.println();
		
		//Question2
		System.out.println("QUESTION 2");
		Question2.fibonacci();
		System.out.println();
		
		//Question3
		System.out.println("QUESTION 3");
		String str = "This is a string to reverse";
		Question3.strReverse(str);
		System.out.println();
		
		//Question4
		System.out.println("QUESTION 4");
		Question4.factorial(5);
		System.out.println();
		
		//Question5
		System.out.println("QUESTION 5");
		System.out.println(Question5.writeSubString("Hello", 1));
		System.out.println();
		
		//Question6
		System.out.println("QUESTION 6");
		System.out.println(Question6.checkEven(3));
		System.out.println();
		
		//Question7
		System.out.println("QUESTION 7");
		Question7 comparison = new Question7();
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("Conan", "quality control", 25));
		employeeList.add(new Employee("Conan", "quality control", 18));
		Collections.sort(employeeList, comparison);
		for(Employee e : employeeList) {
			System.out.println(e.toString());
		}
		System.out.println();
		
		//Question8
		System.out.println("QUESTION 8");
		ArrayList<String> al = new ArrayList<String>();
		al.add("karan");
		al.add("madam");
		al.add("tom");
		al.add("civic");
		al.add("radar");
		al.add("jimmy");
		al.add("kayak");
		al.add("john");
		al.add("refer");
		al.add("billy");
		al.add("did");
		Question8.palindrome(al);
		System.out.println();
		
		//Question9
		System.out.println("QUESTION 9");
		Question9.primeNumbers();
		System.out.println();
		
		//Question10
		System.out.println("QUESTION 10");
		Question10.minUsingTernary(10, 6);
		System.out.println();
		
		//Question11
		System.out.println("QUESTION 11");
		Question11.useFloat();
		System.out.println();
		
		//Question12
		System.out.println("QUESTION 12");
		Question12.evenNums();
		System.out.println();
		
		//Question13
		System.out.println("QUESTION 13");
		Question13.printTriangle();
		System.out.println();
		
		//Question14
		System.out.println("QUESTION 14");
		Question14.switchCase(1);
		Question14.switchCase(2);
		Question14.switchCase(3);
		Question14.switchCase(4);
		System.out.println();
		
		//Question15
		System.out.println("QUESTION 15");
		Question15 operations = new Question15(5, 10);
		System.out.println(operations.subtraction());
		System.out.println();
		
		//Question16
		System.out.println("QUESTION 16");
		//Using the arguments in the Run Configuration
		Question16.numOfChars(args);
		System.out.println();
		
		//Question17
		System.out.println("QUESTION 17");
		Question17.interestAmt();
		System.out.println();
		
		//Question18
		System.out.println("QUESTION 18");
		Question18 testQ18 = new Question18();
		System.out.println("Testing if string has uppercase letters: " + testQ18.checkUpperCase("hoWdY"));
		System.out.println("Converting lowercase to uppercase: " + testQ18.convertLowerToUpper("asdf"));
		System.out.println("Converting string to int value and adding 10 to it: " + testQ18.convertStringToInt("1234"));
		System.out.println();
		
		//Question 19
		System.out.println("QUESTION 19");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			numbers.add(i);
		}
		System.out.println("The sum of even numbers from 1-10 is: " + Question19.evenSum(numbers));
		System.out.println("The sum of odd numbers from 1-10 is: " + Question19.oddSum(numbers));
		System.out.println("The prime numbers from 1-10 are: ");
		Question19.removePrime(numbers);
		System.out.println();
		
		//Question 20
		System.out.println("QUESTION 20");
		Question20.readTextFile("src/Data");
	}
}
