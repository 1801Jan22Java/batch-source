
import java.io.*;
import java.util.Scanner;

import com.revature.challenge.StringCompare;

public class Driver {
	public static void main(String[] args)
	{
		try {
			String fileName = "src/com/revature/challenge/Data.txt";
			Scanner sc = new Scanner(new File(fileName));
			String start = sc.nextLine();
			String end = sc.nextLine();
			String[] bank = sc.nextLine().split(",");
			
			int numSteps = StringCompare.takeSteps(start,  end, bank);
			
			if(numSteps == -1) {
				System.out.println("No such mutation!");
			}
			else {
				System.out.println("Number of mutations: " + numSteps);
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("This is not a valid file path!");
		}
	}
}
