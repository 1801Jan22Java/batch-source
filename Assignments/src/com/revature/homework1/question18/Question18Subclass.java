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
public class Question18Subclass extends Question18Superclass {

	@Override // check for uppercase characters
	public boolean checkForUppercase(String string) {
		// return false if the passed in string is null or empty
		if (string == null || string.isEmpty()) {	
			return false;
		}
		System.out.println("The entered String is: " + string);
		boolean hasUppercase = false;
		char[] charArray = string.toCharArray();	// convert the string to a char array
		for (char c : charArray) {					// iterate through the char array 
			if (Character.isUpperCase(c)) {			// to search for uppercase characters
				hasUppercase = true;
				break;
			}
		}
		return hasUppercase;						// return the result
	}

	@Override // return the uppercase version of the string
	public String lowercaseToUppercase(String string) {
		System.out.println("The entered String is: " + string);
		return string.toUpperCase();				
	}

	@Override	// covert the string to an integer and add 10
	public int convertAndAdd(String string) {
		System.out.println("The entered String is: " + string);
		try {
			int number = Integer.parseInt(string);
	
		} catch (NumberFormatException e) {
			System.out.println("Invalid input!");
			return 0;
		}
		return Integer.parseInt(string) + 10;
	}

}
