package com.revature.homework1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Question20 
{
	public static void readAndPrintFile()
	{
		BufferedReader br = Files.newBufferedReader(new BufferedInputStream(Paths.get("Data.txt"))));
		
		//You're either going to use a reader or a Scanner. I cannot remember.
		FileReader r = new FileReader(new BufferedInputStream("file path");	
		Scanner sc = new Scanner();

		String[] curr = "";
		while(file.nextLine() != null)
		{	
			curr = next().split(":");
			System.out.print("Name: " + curr[0] + " " + curr[1] + "\nAge: " + curr[2] + " years \nState: " + curr[3] + " State"
		}
	}

}
