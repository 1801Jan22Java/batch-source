import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility 
{
	static ArrayList<String> bank = new ArrayList<String>();
	//static final ArrayList<Characters> genes = new ArrayList<String>();
	

	public static int isValidMutation(String start, String end)
	{
		if(!bank.contains(start))
		{
			return -1;
		}
		else if(!bank.contains(end))
		{
			return -1;
		}
		else if(start.equals(end)) {
			return 0;
		}
		
		int count = 0;
		for(int i = 0; i < 8; i++)
		{
			if(start.charAt(1) != end.charAt(i))
			{
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) throws FileNotFoundException 
	{
		System.out.print("Please Enter All Valid Gene Mutations: ");
		Scanner input = new Scanner(System.in); 
		String str = "";
		while(!str.equals("Done"))
		{
			str = input.nextLine(); 
			if(str.length() == 8)
			{
				bank.add(str);
			}
			else
			{
				System.out.println("Invalid Gene String");	 
			}
		}
		System.out.println("Please Enter your starting mutation: ");
		String start = input.nextLine();
		System.out.println("Please Enter your ending mutation: ");
		String end = input.nextLine();
		System.out.println("Returns: "+isValidMutation(start,end));
		input.close(); 
		
	}
}
