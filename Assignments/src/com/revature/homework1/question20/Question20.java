package question20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//for this to run, had to write click new file in the project folder
// write the path in the first line and then MediaDemo at bottom

// Q20. Create a notepad file called Data.txt and enter the following:
// Mickey:Mouse:35:Arizona
// Hulk:Hogan:50:Virginia
// Roger:Rabbit:22:California
// Wonder:Woman:18:Montana
// Write a program that would read from the file and print it out to the screen in the following
// format:
// Name: Mickey Mouse
// Age: 35 years
// State: Arizona State
// Created by: KP Saini

public class Question20 {

	public static void main(String[] args) {
		
		List<String> myList = new ArrayList<>();
		Scanner scanner;									// create a Scanner
		try {
			scanner = new Scanner(new File("Data.txt"));	// instantiate the Scanner
			while (scanner.hasNextLine()) {					// iterate through the file
				Collections.addAll(myList, scanner.nextLine());	// add to the String collection
			}
		} catch (FileNotFoundException e) {					// catch exception if the file is not found
			System.out.println("File not found!");
			e.printStackTrace();
		}
	
		// iterate through the list of strings
		for (String s: myList) {
			String[] stringArray = s.split(":");	// create an array of Strings by deliminating by ":"
			// print to the console in the desired format
			System.out.println("Name: " + stringArray[0] + " " + stringArray[1]);
			System.out.println("Age: " + stringArray[2] + " years");
			System.out.println("State: " + stringArray[3] + " State\n");
		}
	}
	
}
