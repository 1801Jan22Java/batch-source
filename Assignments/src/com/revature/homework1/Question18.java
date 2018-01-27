package com.revature.homework1;

public class Question18 extends Question18Abstract{

	@Override
	public boolean checkUpperCase(String str) {
		boolean hasUpper = false;
		char[] chars = str.toCharArray();
		for(char c : chars) {
			if(Character.isUpperCase(c)) {
				hasUpper = true;
				break;
			}
		}
		
		return hasUpper;
	}

	@Override
	public String convertLowerToUpper(String str) {
		return str.toUpperCase();
	}

	@Override
	public int convertStringToInt(String str) {
		
		int num = Integer.parseInt(str);
		return num + 10;
	}

	
	
}
