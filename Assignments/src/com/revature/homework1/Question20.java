package com.revature.homework1;

import java.io.*;
import java.util.*;

public class Question20 {

	private static ArrayList<String> arr = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("src/data.txt");
		 
        BufferedInputStream bin = new BufferedInputStream(fin);

        int ch;
        String str = "";
        while ((ch=bin.read()) != -1) {
        	if ((char)ch == '\n') {
        		arr.add(str);
        		str = "";
        		continue;
        	}
        	str += Character.toString((char)ch);
        }
 
        // close the file
        fin.close();
		
		for (int i = 0; i < arr.size(); i++) {
			String data = arr.get(i);
			String [] dataArr = data.split(":");
			System.out.println("Name: " + dataArr[0] + " " + dataArr[1]);
			System.out.println("Age: " + dataArr[2]);
			System.out.println("State: " + dataArr[3] + "\n");
		}
		
	}
}
