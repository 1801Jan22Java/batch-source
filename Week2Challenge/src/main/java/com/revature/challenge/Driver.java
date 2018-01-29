package com.revature.challenge;

import java.io.*;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args)
	{
		try {
			String fileName = "src/main/java/com/revature/challenge/Data.txt";
			Scanner sc = new Scanner(new File(fileName));
			String start = sc.nextLine();
			String end = sc.nextLine();
			String[] bank = sc.nextLine().split(",");
			
			int numSteps = StringCompare.takeSteps(start,  end, bank);
			
			if(numSteps == -1) {
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
				System.out.print("Bank: ");
				for(String s : bank) {
					System.out.print(s + " ");
				}
				System.out.println();
				System.out.println("No such mutation!");
			}
			
			else if(numSteps == -2) {
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
				System.out.print("Bank: ");
				for(String s : bank) {
					System.out.print(s + " ");
				}
				System.out.println();
				System.out.println("Invalid input!");
			}
			else {
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
				System.out.print("Bank: ");
				for(String s : bank) {
					System.out.print(s + " ");
				}
				System.out.println();
				System.out.println("Number of mutations: " + numSteps);
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("This is not a valid file path!");
		}
	}
}
