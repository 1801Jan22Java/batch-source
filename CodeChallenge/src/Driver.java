import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		//creates variables to get user input and stores it into firstGene, and bankChoice
		Scanner sc = new Scanner(System.in);
		String firstGene;
		int bankChoice = 0;
		
		//Gets the starting gene string from the user
		System.out.println("Using any combination of the letters 'A', 'C', 'G', and 'T'");
		System.out.println("Enter a 8 character gene string to start from: ");
		firstGene = sc.nextLine();
		
		//Gets the chose of gene bank to end at from the user
		System.out.println("Choose from the list of gene strings to end at from the bank: ");
		System.out.println("1:[AACCGGTA], 2:[AACCGCTA], 3:[AAACGGTA]");
		bankChoice = sc.nextInt();
		
		//Program terminates after attempting to make a call to the bankMutate method in my Utility 
		//class. I should have made my utility class nested within the driver class but I like to make
		//my life harder. 
		Utility.bankMutate(firstGene, bankChoice);
		
		sc.close();
	}
	

}
