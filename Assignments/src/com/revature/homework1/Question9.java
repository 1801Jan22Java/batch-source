package com.revature.homework1;

import java.util.ArrayList;

public class Question9 {
	
	public static ArrayList<Integer> findPrimes(ArrayList<Integer> list){
		ArrayList<Integer> primeList = new ArrayList<>() ;
		// itterates through list and if when the number is divided by 2 if there is no remainder,it is odd and removed from ArrayList
		for (int i = 1; i < list.size()+1; i++){
			if( i % 2 != 0) {
			primeList.add(i);
			System.out.println(i);
			
			}
			
		}

		return primeList;
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> numList = new ArrayList<>();
		// creates list 1 to 100
		for (int i = 1; i < 101; i++){
			numList.add(i);
		}
		
		findPrimes(numList);
	}

}
