package com.revature.homework1;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Question 1
		System.out.println("\nQuestion 1");
		Question1 q1 = new Question1();
		 int [] arrayToBeSorted = {1,0,5,6,3,2,3,7,9,8,4};
		 for(int i =0 ; i< arrayToBeSorted.length;i++)
		 {
			 System.out.print(arrayToBeSorted[i]+ " ");
		 }
		 System.out.println();
		 q1.bubbleSort(arrayToBeSorted);
		 for (int i =0;i<arrayToBeSorted.length;i++)
		 {
			 System.out.print(arrayToBeSorted[i]+ " ");
		 }
		 System.out.println();
		
		//Question 2
		System.out.println("\nQuestion 2");
		Question2 q2 = new Question2();
		//Displays first 25 fibonacci numbers
		q2.displayNums();
		
		//Question 3
		 System.out.println("\nQuestion 3");
		 Question3 q3=new Question3();
		System.out.println(q3.reverseAString("Sport coat"));
		System.out.println(q3.reverseAString("4342k3l0"));
		
		//Question 4
		 System.out.println("\nQuestion 4");
		System.out.println(Question4.factorialRecursive(5));
		
		//Question 5
		System.out.println("\nQuestion 5");
		Question5 q5 = new Question5();
		System.out.println(q5.subString("yellow", 4));
		System.out.println(q5.subString("Virginia", 20));
		
		//Question 6
		 System.out.println("\nQuestion 6");
		System.out.println(Question6.isEven(7));
		System.out.println(Question6.isEven(6));
		System.out.println(Question6.isEven(0));
		System.out.println(Question6.isEven(10001));
		
		//Question 7 
		//Creating a list of objects of type Employee
		System.out.println("\nQuestion 7");
		Question7 q7= new Question7();
		Employee e1 = new Employee("Craig","Pelton","Dean",44);
		Employee e2 = new Employee("Jeff","Winger","Law",40);
		Employee e3 = new Employee("Benjamin","Chang","Spanish",35);
		Employee e4 = new Employee("Ian","Duncan","Psychology",46);
		List<Employee> empList= new ArrayList<Employee>();
		Collections.addAll(empList,e1,e2,e3,e4);
		
		//Sorts Employee by firstName
		System.out.println("\n\nSorted by firstName");
		List <Employee> empList2 = q7.sortEmployeeFirstName(empList);
		for(Employee e: empList2)
		{
			System.out.println(e);
		}
		//Sorts Employee by lastName
		System.out.println("\n\nSorted by lastName");
		List <Employee> empList5 = q7.sortEmployeeLastName(empList);
		for(Employee e: empList5)
		{
			System.out.println(e);
		}
		//Sorts Employee by age
		System.out.println("\n\nSorted by age");
		List <Employee> empList3 = q7.sortAge(empList);
		for(Employee e: empList3)
		{
			System.out.println(e);
		}
		
		//Sorts Employee by department
		System.out.println("\n\nSorted by department");
		List <Employee> empList4 = q7.sortDepartment(empList);
		for(Employee e: empList4)
		{
			System.out.println(e);
		}
		
		
		//Question 8
		
		System.out.println("\nQuestion 8");
		Question8 q8 = new Question8();
		ArrayList<String>list = q8.storeStrings("karan","madam", "tom", "civic", "radar","jimmy",
				"kayak","john","refer","billy","did");
		
		ArrayList<String>palindromes = q8.storePalindromes(list);
		for(int i =0;i<palindromes.size();i++)
		{
			System.out.println(palindromes.get(i));
		}
	
		//Question 9 
		
		System.out.println("\nQuestion 9");
		Question9 q9 = new Question9();
		q9.printPrime();
		
		
		//Question 10
		 System.out.println("\nQuestion 10");
		 Question10 q10 = new Question10();
		System.out.println(q10.findMinimum(9, 10));
		System.out.println(q10.findMinimum(9, -10));
		System.out.println(q10.findMinimum(0, 0));
		
		//Question 11 
		 System.out.println("\nQuestion 11");
		Question11 q11= new Question11();
		q11.accessVariables();
		
		//Question 12
		System.out.println("\nQuestion 12");
		Question12 q12=new Question12();
		q12.showEvenNumbers();
		
		
		//Question 13  // Working on a better solution...
		System.out.println("\nQuestion 13");
		Question13 q13 = new Question13();
		q13.displayTriangle();
		
		
		//Question 14
		System.out.println("\nQuestion 14");
		Question14 q14 = new Question14();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please make an integer selection between 1 and 3: ");
		String input= sc.nextLine();
		int inputInt =q14.validateInput(input);
		while((inputInt<=0)||(inputInt>=4))
		{
			System.out.println("Invalid input.  Please make an integer selection between 1 and 3: ");
			input= sc.nextLine();
			inputInt = q14.validateInput(input);
		}
		q14.switchRun(inputInt);
	//	q14.switchRun(a);
		
		
		
		//Question 15 
		System.out.println("\nQuestion 15");
		//Calling Question15 by its main method.
		Question15 q15 = new Question15();
		q15.main(args);
		
		//Question 16 Version A
		Question16a.main(args);
		
		//Question 16
		System.out.println("\nQuestion 16");
		Question16 q16 = new Question16();
		Scanner sc2=new Scanner (System.in);
		
		ArrayList<String> stringList = new ArrayList<String>();
		System.out.println("Please add a string: ");
		String q16Input = sc.nextLine();
		stringList.add(q16Input);
		while(!q16Input.isEmpty())
		{
			System.out.println("Please add another string: ");
			q16Input=sc2.nextLine();
			stringList.add(q16Input);
		}
		String [] strArray = q16.makeStrArray(stringList);
		
	
		System.out.println(q16.countChars(strArray));
	
		
		//Question 17
		
		
		System.out.println("\nQuestion 17");
		Question17 q17 = new Question17();
		Scanner sc17 = new Scanner(System.in);
		/*
		 * Gathering user input data - number of years, rate and principal
		 * */
		System.out.println("Please enter the number of years: " );
		String yearStr =sc17.nextLine();
		while(!q17.verifyYearInt(yearStr)){
			System.out.println("The number you entered was invalid, please try again:");
			yearStr =sc17.nextLine();
			q17.verifyYearInt(yearStr);
		}
		
		System.out.println("Please enter the rate: ");
		String rateStr =sc17.nextLine();
		while(!q17.verifyRateFloat(rateStr)){
			System.out.println("The number you entered was invalid, please try again:");
			rateStr =sc17.nextLine();
			q17.verifyRateFloat(rateStr);
		}
		
		System.out.println("Please enter the principal");
		String principal =sc17.nextLine();
		while(!q17.verifyPrincipalFloat(principal))
		{
			System.out.println("The number you entered was invalid, please try again:");
			principal=sc17.nextLine();
			q17.verifyPrincipalFloat(principal);
		}
		//Displays interest based on user input.
		q17.displayInterest();
		
		//Question 18  
		System.out.println("\nQuestion 18");
		Q18ConcreteChildClass c= new Q18ConcreteChildClass();
		
		//Converts all lowercase string to uppercase
		System.out.println(c.hasUppercase("hello world"));
		//Attempts to see if numbers have uppercase 
		System.out.println(c.hasUppercase("11111"));
		System.out.println(c.hasUppercase("HELLO WORLD"));
		System.out.println(c.convertToUpper("11232"));
		System.out.println(c.convertToUpper("HI THERE"));
		System.out.println(c.convertToUpper("hello there"));
		System.out.println(c.convertToInt("11232"));
		//Attempts to convert a string of alphanumeric and special characters to integers
		System.out.println(c.convertToInt("jfdkla;343"));
		
		
		//Question 19   
		Question19 q19=new Question19();
		System.out.println("\nQuestion19");
		ArrayList<Integer> question19List = q19.insertInt();
		for (Integer i : question19List){
			System.out.println(i);
		}
		System.out.println("Adding odds");
		System.out.println(q19.addOdds(question19List));
		System.out.println("Adding evens");
		System.out.println(q19.addEvens(question19List));
		
		q19.removePrimes(question19List);
		for(int i = 0;i<question19List.size();i++)
		{
			System.out.print(question19List.get(i) + " ");
		}
		
		
		System.out.println("\nQuestion 20");
		Question20 q20 = new Question20();
		//Creating the data file using the relative path - File located in the package.
		File file = new File("Data.txt");
		q20.displayData(q20.intakeData(file));
		
		

	}

}
