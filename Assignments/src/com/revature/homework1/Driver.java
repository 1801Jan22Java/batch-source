package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
		//Question1
		System.out.println("Question 1");
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		Question1.isSorted(array);
		
		//Question2
		System.out.println("Question 2");
		Question2.fibonacci();
		
		//Question3
		System.out.println("Question 3");
		String str = "This is a string to reverse";
		Question3.strReverse(str);
		
		//Question4
		System.out.println("Question 4");
		Question4.factorial(5);
		
		//Question5
		System.out.println("Question 5");
		System.out.println(Question5.writeSubString("Hello", 1));
		
		//Question6
		System.out.println("Question 6");
		System.out.println(Question6.checkEven(3));
		
		//Question7
		System.out.println("Question 7");
		Question7 comparison = new Question7();
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("Conan", "quality control", 25));
		employeeList.add(new Employee("Conan", "quality control", 18));
		Collections.sort(employeeList, comparison);
		for(Employee e : employeeList) {
			System.out.println(e.toString());
		}
		System.out.println("NEED TO FINISH THAT PROBLEM");
		
		//Question8
		System.out.println("Question 8");
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
		
		//Question9
		System.out.println("Question 9");
		Question9.primeNumbers();
		
		//Question10
		System.out.println("Question 10");
		Question10.minUsingTernary(10, 6);
		
		//Question11
		System.out.println("Question 11");
		Question11.useFloat();
		
		//Question12
		System.out.println("Question 12");
		Question12.evenNums();
		
		//Question13
		System.out.println("Question 13");
		Question13.printTriangle();
		
		//Question14
		System.out.println("Question 14");
		//Question14.switchCase(1);
		Question14.switchCase(2);
		Question14.switchCase(3);
		Question14.switchCase(4);
		
		//Question15
		System.out.println("Question 15");
		Question15 operations = new Question15(5, 10);
		System.out.println(operations.subtraction());
		
		//Question16
		System.out.println("Question 16");
		//Using the arguments in the Run Configuration
		Question16.numOfChars(args);
		
		//Question17
		System.out.println("Question 17");
		//Question17.interestAmt();
		
		//Question18
		System.out.println();
	}
}
