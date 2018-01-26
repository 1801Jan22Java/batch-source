package com.revature.homework1;

import java.util.ArrayList;
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
		//System.out.println(Question6.isEven(0));
		//System.out.println(Question6.isEven(10001));
		
		//Question 7 //NEED TO WORK ON.
		
		//Question 8
		//System.out.println(Question8.isPalindrome("werewolf"));
		//System.out.println(Question8.isPalindrome("warewilf"));
		//System.out.println(Question8.isPalindrome("racecar"));
		
		
		//Question 9 // NEED TO WORK ON
		ArrayList <Double> list = new ArrayList<Double>();
		list=Question9.fillArrayList();
		Question9.printPrime(list);
		System.out.println(Question10.findMinimum(9, 10));
		
		//Question 11 - Created but need to show
		
		//Question 12
		//Question12.showEvenNumbers();
		
		//Question 13
		
		
		
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
		
		
		
		//Question 15 // NEED TO WORK ON
		
		
		//Question 16  // NEED TO WORK ON
		
		
		//Question 17
		
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
