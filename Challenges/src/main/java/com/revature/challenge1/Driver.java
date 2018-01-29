package com.revature.challenge1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		String start = new String();
		String end = new String();
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\challenge1\\start.txt"));
			while(input.hasNextLine()) {
				start = input.nextLine();
				System.out.println("Original gene = " + start);
			}
		} catch (IOException e) {
			System.out.println("Sorry, the start file was not found.");
		}
		
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\challenge1\\end.txt"));
			while(input.hasNextLine()) {
				end = input.nextLine();
				System.out.println("New gene = " + end);
			}
		} catch (IOException e) {
			System.out.println("Sorry, the end file was not found.");
		}
		
		System.out.println(GeneBank.countModifications(start, end));
		
		
		
		

	}

}
