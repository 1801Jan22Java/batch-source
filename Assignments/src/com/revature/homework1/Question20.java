package com.revature.homework1;

import java.io.*;
import java.util.*;

public class Question20 {

	private static ArrayList<String> arr = new ArrayList<String>();
	public static void main(String[] args) {
		File f = new File("C:\\GitRepos\\batch-source\\Assignments\\src\\com\\revature\\homework1\\Data.txt");
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				arr.add(sc.nextLine());
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < arr.size(); i++) {
			String data = arr.get(i);
			String [] dataArr = data.split(":");
			System.out.println("Name: " + dataArr[0] + " " + dataArr[1]);
			System.out.println("Age: " + dataArr[2]);
			System.out.println("State: " + dataArr[3] + "\n");
		}
		
	}
}
