package calculator;

import java.util.Scanner;

public class Driver {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		do {
			try {
				System.out.println("\nSelect an operation by entering its corresponding number: " 
						+"\n1 - Addition"
						+"\n2 - Subtraction"
						+"\n3 - Multiplication"
						+"\n4 - Division"
						+"\n0 - Exit Calculator");
				
				String doSelectionString = input.nextLine();
				int doSelection =  Integer.parseInt(doSelectionString);
				
				switch (doSelection) {
				case 0:
					return;
				case 1:
					Calculator.performAddition();
					break;
				case 2:
					Calculator.performSubtraction();
					break;
				case 3:
					Calculator.performMultiplication();
					break;
				case 4:
					Calculator.performDivision();
					break;
				default:
					System.out.println("Invalid input!");
					break;
				}
				
			} catch (NumberFormatException ex) {
				System.out.println("Invalid Input!");
			}
		} while(true);
	}
}