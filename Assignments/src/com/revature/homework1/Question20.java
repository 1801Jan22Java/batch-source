package com.revature.homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Question20 {
	
	public static void printFormat(ArrayList<String> txtInfo) {
			for(String s : txtInfo) {
				String[] element = s.split(":");
				System.out.println("Name: " + element[0] + " " + element[1]);
				System.out.println("Age: " + element[2] + " years");
				System.out.println("State: " + element[3] + " State");
				System.out.println();
			}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("src/com/revature/homework1/Data.txt");
		Scanner scannerObj = new Scanner(file);
		ArrayList<String> txtStrings = new ArrayList<String>();
		while (scannerObj.hasNextLine()) {
			txtStrings.add(scannerObj.nextLine());
		}
		printFormat(txtStrings);
		scannerObj.close();
	}
	
	
}
