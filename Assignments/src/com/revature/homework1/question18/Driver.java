package question18;

//Q18. Write a program having a concrete ;subclass that inherits three abstract methods from a
//superclass. Provide the following three implementations in the subclass corresponding to the
//abstract methods in the superclass:
//1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any
//are found.
//2. Convert all of the lower case characters to uppercase in the input string, and return the
//result.
//3. Convert the input string to integer and add 10, output the result to the console.
//Create an appropriate class having a main method to test the above setup.
// Created by: KP Saini

public class Driver {

	public static void main(String[] args) {

		// construct a Question18Subclass object with its default constructor
		Question18Subclass question18 = new Question18Subclass();
		
		// invoke the Question18Subclass methods with appropriate messages to the console
		System.out.println("Check for uppercase characters in a string, and return "
				+ "‘true’ or ‘false’ depending if any are found.");
		System.out.println(question18.checkForUppercase("Peter Smith"));
		System.out.println(question18.checkForUppercase("peter smith"));
		
		System.out.println("\nConvert all of the lower case characters to uppercase in "
				+ "the input string, and return the result.");
		System.out.println(question18.lowercaseToUppercase("Peter Smith"));
		
		System.out.println("\nConvert the input string to integer and add 10, output "
				+ "the result to the console.");
		System.out.println(question18.convertAndAdd("20"));
	}

}
