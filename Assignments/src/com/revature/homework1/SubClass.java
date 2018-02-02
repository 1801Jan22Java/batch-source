package com.revature.homework1;

public class SubClass extends SuperClass {

	/* (non-Javadoc)
	 * returns true if all characters are uppercase and false if otherwise
	 */
	@Override
	boolean isAllUppercase(String str) {
		for(int i = 0; i<str.length(); i++)
		{
			if(Character.isLowerCase(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * converts all lower case characters int the string to upper case
	 */
	@Override
	String convertToUppercase(String str) {
		// TODO Auto-generated method stub
		return str.toUpperCase();
	}

	/* (non-Javadoc)
	 * converts the string to int and adds 10
	 */
	@Override
	void addToString(String str) {
		
		for(int i = 0; i<str.length(); i++)					//cycle through the array
		{
			if(Character.isDigit(str.charAt(i)))	 			//check each character for digit
			{
				continue;										//if its integer go to next iteration
			}
			else 
			{
				System.out.println("invalid string");			//if its anything else return empty string
				return;
			}
		}
		int num = Integer.parseInt(str);

		
	}
	
	

}
