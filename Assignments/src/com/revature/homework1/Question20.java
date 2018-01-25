package com.revature.homework1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
	 * Create a notepad file called Data.txt and enter the following:
	 * Mickey:Mouse:35:Arizona
	 * Hulk:Hogan:50:Virginia
	 * Roger:Rabbit:22:California
	 * Wonder:Woman:18:Montana
	 * Write a program that would read from the file and print it out to the screen in the following format:
	 * 
	 * Name: Mickey Mouse
	 * Age: 35 years
	 * State: Arizona State
	 */

public class Question20 {

	public static void main(String[] args) {
		funWithFileIO();

	}

	public static void funWithFileIO() {

		FileInputStream file = null;
		Scanner scan;
		String input, name, age, state;
		StringTokenizer st;

		input = name = age = state = "";

		//need to find the file so we can read from it
		try {
			file = new FileInputStream("E:\\Documents\\Revature\\repos\\1801-jan22-java\\"
					+ "batch-source\\Assignments\\src\\com\\revature\\homework1\\Data.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//need a scanner to read from the file
		scan = new Scanner(file);

		//while there are ore lines in the input
		while (scan.hasNextLine()) {
			input = scan.nextLine();
			st = new StringTokenizer(input, ": \t\n\r\f");

			//I am assuming correct input in the file
			name = st.nextToken();
			name += " " + st.nextToken();
			age = st.nextToken();
			state = st.nextToken();

			System.out.println("Name: " + name);
			System.out.println("Age: " + age + " years");
			System.out.println("State: " + state + " State\n");

		}
		//Nedd to ensure the file is closed
		scan.close();

	}

}
