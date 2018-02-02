package com.revature.homework1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Question20 {

	public static void main(String[] args) {
		
		/*
		Mickey:Mouse:35:Arizona
		Hulk:Hogan:50:Virginia
		Roger:Rabbit:22:California
		Wonder:Woman:18:Montana
		Write a program that would read from the file and print it out to the screen in the following
		format:
		Name: Mickey Mouse
		Age: 35 years
		State: Arizona State
		 */

		//Path to the data file
		String input = readFile("src/res/Data.txt");
		
		//System.out.println(input);
		
		//Split string using the ':' delimiter
		String[] splitInput = input.split(":");
		
		//Print out the string and format it
		for(int i = 0; i < splitInput.length; i+=4) {
			System.out.println("Name: " + splitInput[i] + " " + splitInput[i + 1]);
			System.out.println("Age: " + splitInput[i+2]);
			System.out.println("State: " + splitInput[i+3] + "\n");
		}

	}

	public static String readFile(String fileName) {
		try {
			//Make a file reader so we can read text in from the file
			FileReader reader = new FileReader(fileName);
			BufferedReader textRead = new BufferedReader(reader);
			String data = "";
			
			//Keep reading lines until eof add in a \n character after each line
			while(textRead.ready())
				data += (textRead.readLine()) + ":";
			
			return data;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return null;
	}
}
