package com.revature.homework1;

import java.util.ArrayList;

public class Question12 {
	
	public static ArrayList<Integer> findEvens(ArrayList<Integer> list){
		ArrayList<Integer> evenList = new ArrayList<>() ;
		for (int i : list){
			if( i % 2 == 0) {
			evenList.add(i);
			
			}
			
		}
		


		return evenList;
		
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> numList = new ArrayList<>();
		for (int i = 1; i < 101; i++){
			numList.add(i);
		}
		
		ArrayList<Integer> newList = new ArrayList<>();
		newList = findEvens(numList);
		
		for(int num : newList) {
			System.out.println(num);
		}
		
	}

}
