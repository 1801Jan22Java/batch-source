package com.revature.homework1;

	/*
	 * Gin/ Q18. Write a program having a concrete ;subclass that inherits three abstract methods from a superclass.  
	 * Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
			1. 	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
			2. 	Convert all of the lower case characters to uppercase in the input string, and return the result.
			3. 	Convert the input string to integer and add 10, output the result to the console.
			Create an appropriate class having a main method to test the above setup.
	 */
	
	public class Question18 {
	
			public static void main(String[] args) {
				FineOperator fo = new FineOperator();
				
				System.out.println(fo.checkIfUppercaseExist("watermelon is Always Good"));
				System.out.println(fo.convertLowerCaseToUpperCase("does it include lowercase?"));
				System.out.println(fo.switchToNumberAndAddTen("15"));		// please input 'string' which can be parsed into Integer
			}
		
	}
	
	abstract class Operator {
		
		public abstract Boolean checkIfUppercaseExist(String text);
		public abstract String convertLowerCaseToUpperCase(String text);
		public abstract Integer switchToNumberAndAddTen (String actuallyNumber );
	};
	
	class FineOperator extends Operator {

		@Override
		public Boolean checkIfUppercaseExist(String text) {
			boolean ifTrue = false;
			char[] alphabets = text.toCharArray();
			for (char a : alphabets) {
				if (Character.isUpperCase(a)) {
					ifTrue = true;
					break;
				}
			}
			return ifTrue;
		}

		@Override
		public String convertLowerCaseToUpperCase(String text) {
			text = text.toUpperCase();
			return text;
		}

		@Override
		public Integer switchToNumberAndAddTen(String actuallyNumber) {
			int number = 0;
			try {
				number = Integer.parseInt(actuallyNumber);
				return number + 10;
			} catch (NumberFormatException e) {
				System.out.println("please input only number");
				return number;
			} 
		}
		
	}
	
