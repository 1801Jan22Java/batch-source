package com.revature.homework1;
import java.util.*;
// almost done
public class ProblemEight {
	
	public static void funWithLists(String[] things) {
		ArrayList<String> no_drone = new ArrayList<String>();
		ArrayList<String> drone = new ArrayList<String>();
		int half = things.length/2;
		boolean drones = false;
		
		for(int i = 0; i< half; i ++) {
			//holder = things[i];
			if(things.length%2==1) {
				for(int j = 0; j< half; j++) {
					if(things[i].charAt(j) != things[i].charAt(things.length-j)) {
						// not a pallendrone
					}
					else {
						System.out.println("drone");
					}
					
				}
			}
		}
		
		
		
	}
	
	public static void main(String args[]) {
		String [] things = {"karan","madam","tom","civic"
				,"radar","jimmy","kayak","john","refer","billy"
				,"did"};
		
		//funWithLists(things);
		/*
		String thing = "did";
		int half = thing.length()/2;
		
			if(thing.length()%2==1) {
				for(int j = 0; j< half; j++) {
					if(thing.charAt(j) != thing.charAt(thing.length()-j-1)) {
						System.out.println(" Mis-Match ! compared front value "+thing.charAt(j)+" and back value "+thing.charAt(thing.length()-j-1));
					}
					else {
						System.out.println("Match ! compared front value "+thing.charAt(j)+" and back value "+thing.charAt(thing.length()-j-1));
					}
					
				}
			}
		
		*/
	}

}
