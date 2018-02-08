package com.revature.homework1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Question20 
{
	public static void readAndPrintFile()
	{
		String curr = "";
		String[] arr = null;
		try {
			//Wrapping FileReader object in a BufferedReader and passing the path of the Data.txt file.
			BufferedReader br = new BufferedReader(new FileReader("src\\com\\revature\\homework1\\Data.txt"));

			//if the current line is not null
			while((curr = br.readLine()) != null)
			{	
				//split the word by the delimiter ":"
				//and add it to an array
				arr = curr.split(":");
				//format the string and print the contents of arr
				System.out.println("Name: " + arr[0] + " " + arr[1] + "\nAge: " + arr[2] + " years \nState: " + arr[3] + " State\n");
			}
			//close br to prevent memory leakage
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
