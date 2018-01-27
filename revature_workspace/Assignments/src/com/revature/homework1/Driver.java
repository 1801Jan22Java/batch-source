package com.revature.homework1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Question 1
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
		//System.out.println(Question2.fibonacciRecursive(5));
		
		//Question 3
		//System.out.println(Question3.reverseAString("dog"));
		
		//Question 4
		//System.out.println(Question4.factorialRecursive(5));
		
		//Question 5
		//System.out.println(Question5.subStrang("yellow", 4));
		
		//Question 6
		//System.out.println(Question6.isEven(7));
		//System.out.println(Question6.isEven(6));
		System.out.println(Question6.isEven(0));
		//System.out.println(Question6.isEven(10001));
		
		//Question 7 
		
		Question7 q7= new Question7();
		Employee e1 = new Employee("Mikhail","Gorbachev","History",32);
		Employee e2 = new Employee("Benedict","Anderson","Anthropology",31);
		Employee e3 = new Employee("Ada","Lovelace","Computer Science",27);
		Employee e4 = new Employee("Konstantin","Stanislavsky","Theater",34);
		List<Employee> empList= new ArrayList<Employee>();
		Collections.addAll(empList,e1,e2,e3,e4);
		
		
		System.out.println("\n\nSorted by firstName");
		List <Employee> empList2 = q7.sortEmployeeFirstName(empList);
		for(Employee e: empList2)
		{
			System.out.println(e);
		}
		
		System.out.println("\n\nSorted by lastName");
		List <Employee> empList5 = q7.sortEmployeeLastName(empList);
		for(Employee e: empList5)
		{
			System.out.println(e);
		}

		System.out.println("\n\nSorted by age");
		List <Employee> empList3 = q7.sortAge(empList);
		for(Employee e: empList3)
		{
			System.out.println(e);
		}
		
		
		System.out.println("\n\nSorted by department");
		List <Employee> empList4 = q7.sortDepartment(empList);
		for(Employee e: empList4)
		{
			System.out.println(e);
		}
		
		
		
		
		
		
		//Question 8
		//System.out.println(Question8.isPalindrome("werewolf"));
		//System.out.println(Question8.isPalindrome("warewilf"));
		//System.out.println(Question8.isPalindrome("racecar"));
		/*
		
		//Question 9 // NEED TO WORK ON
		ArrayList <Double> list = new ArrayList<Double>();
		list=Question9.fillArrayList();
		Question9.printPrime(list);
		System.out.println(Question10.findMinimum(9, 10));
		
		//Question 11 - Created but need to show
		
		//Question 12
		//Question12.showEvenNumbers();
		
		//Question 13  // Working on.  All kinds of effed up.
		
		
		
		//Question 14
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
		
		
		*/
		//Question 15 // NEED TO WORK ON
		
		
		//Question 16
		
	/*	String [] strs = {"hot","cold","yes","no"};
		Question16 q16 = new Question16();
		//System.out.println(q16.countChars(strs));
		Scanner sc2=new Scanner (System.in);
		
		ArrayList<String> lists = new ArrayList<String>();
	//	System.out.println("Add a string: ");
		while(!sc2.nextLine().isEmpty())
		{
			System.out.println("Add another string: ");
			lists.add(sc2.nextLine());
		}
		String [] strArray = new String[lists.size()];
		for(int i =0;i<lists.size();i++)
		{
			
			strArray[i]=lists.get(i);
			System.out.println(strArray[i]);
		}
		System.out.println(strArray.toString());
		System.out.println(q16.countChars(strArray));
	
		*/
		
		//Question 17
		/*
		Question17 q17 = new Question17(10,2434.60f,2.5f);
		q17.displayInterest();
		
		//Question 18
		
		Q18ConcreteChildClass c= new Q18ConcreteChildClass();
		System.out.println(c.hasUppercase("hello world"));
		System.out.println(c.hasUppercase("11111"));
		System.out.println(c.hasUppercase("HELLO WORLD"));
		System.out.println(c.convertToUpper("11232"));
		System.out.println(c.convertToUpper("HI THERE"));
		System.out.println(c.convertToUpper("hello there"));
		System.out.println(c.convertToInt("11232"));
		System.out.println(c.convertToInt("jfdkla;343"));
		
		//Question 19
		ArrayList<Integer> question19List = Question19.insertInt();
		for (Integer i : question19List){
		//	System.out.println(i);
		}
		//Question19.addOdds(question19List);
		//Question19.addEvens(question19List);
		
		//Question19.removePrimes(question19List);
		/*for(int i = 0;i<question19List.size();i++)
		{
			System.out.println(question19List.get(i));
		}*/
		//Question 20  //WORKING ON IT
		
		

	}

}
