package com.revature.homework1;

// Concrete SubClass for Q18
public class SubClass extends AbstractClass {

	@Override
	public boolean checkUpper(String s) {
		for(int i=0; i<s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i))) {
				return true;
			};
		}
		return false;
	}

	@Override
	public String upperCaseAll(String s) {
		String lower = s.toUpperCase();
		return lower;
	}

	@Override
	public int stringToIntAddTen(String s) {
		try {
			int i = Integer.parseInt(s) ;
			return i + 10;
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("not a valid input.");
		}
		return 0;
	}

}
