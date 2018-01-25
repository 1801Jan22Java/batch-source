package com.revature.homework1;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Question 1
		System.out.println(Question2.fibonacciRecursive(5));
		System.out.println(Question3.reverseAString("dog"));
		System.out.println(Question4.factorialRecursive(5));
		System.out.println(Question5.subStrang("yellow", 4));
		System.out.println(Question6.isEven(7));
		System.out.println(Question6.isEven(6));
		System.out.println(Question6.isEven(0));
		System.out.println(Question6.isEven(10001));
		//Question 7 
		System.out.println(Question8.isPalindrome("werewolf"));
		System.out.println(Question8.isPalindrome("racecar"));
		ArrayList <Double> list = new ArrayList<Double>();
		list=Question9.fillArrayList();
		Question9.printPrime(list);
		System.out.println(Question10.findMinimum(9, 10));
		//Question 11 - Created but need to show
		Question12.showEvenNumbers();
		//Question 13
		//Question 14
		//Question 15
		//Question 16
		//Question 17
		//Question 18
		//Question 19
		ArrayList<Integer> question19List = Question19.insertInt();
		Question19.addOdds(question19List);
		Question19.addEvens(question19List);
		
		Question19.removePrimes(question19List);
		/*for(int i = 0;i<question19List.size();i++)
		{
			System.out.println(question19List.get(i));
		}*/
		//Question 20


	}

}
