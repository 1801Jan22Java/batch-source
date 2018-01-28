package com.revature.homework1;

import java.util.ArrayList;

public class Question19 {
	
	public static int addEvens(ArrayList<Integer> list){
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			double temp = (list.get(i)%2);
			if(temp == 0) {
				sum += list.get(i);
				}
		}
		return sum;
		
		
	}
	
	public static int addOdds(ArrayList<Integer> list){
		int sum = 0;
		for(int i = 0; i <  list.size(); i++) {
			double temp = (list.get(i)%2);
			if(temp != 0) {
				sum += list.get(i);
				}
		}
		return sum;
		
		
	}
	
	public static ArrayList<Integer> removeOdds(ArrayList<Integer> list){

		for(int i = 0; i < list.size(); i++) {
			double temp = list.get(i)%2;
			if((temp) == 0) {
				list.remove(i);
				}
		}
		return list;
		
		
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> testList = new ArrayList<>();
		for(int i =1; i<=10; i++) {
			testList.add(i);
		}
		
		System.out.println("Original list");
		for(int i =0; i<10; i++) {
			System.out.println(testList.get(i));
		}
		
		System.out.println("Even numbers added = " + addEvens(testList));
		System.out.println("Odd numbers added = " + addOdds(testList));


		ArrayList<Integer> oddOnlyList = new ArrayList<>();
		System.out.println("List with only odd numbers:");
		oddOnlyList = removeOdds(testList);
		for(int i =0; i < oddOnlyList.size(); i++) {

			System.out.println(oddOnlyList.get(i));
		}
		



	}

}
