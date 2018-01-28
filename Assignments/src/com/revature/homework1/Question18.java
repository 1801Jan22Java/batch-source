package com.revature.homework1;

public class Question18 {
	public static void main(String[] args) {
		funWitStrangs fWS = new funWitStrangs();
		
		System.out.println(fWS.capital("these are not the letters you're looking for"));
		System.out.println(fWS.capital("These, however, are"));
		
		System.out.println(fWS.convertToUpper("like shouting, but in text form, and twice as annoying"));
		
		/*
		 * I do now! It throws a Number format exception. Should have guessed.
		 * fWS.convertNAdd("I actually don't have any clue what this does");
		 */
		fWS.convertNAdd("10");
	}

}	

abstract class funWithStrangs{
	abstract boolean capital(String str);
	abstract String convertToUpper(String str);
	abstract void convertNAdd(String str);
}
	
class funWitStrangs extends funWithStrangs{
	public funWitStrangs() {}
	
	public boolean capital(String str) {
		char[] cs = str.toCharArray();
		for(char c:cs) {
			if(Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}
		
	public String convertToUpper(String str) {
		String upperStr = str.toUpperCase();
		return upperStr;
	}
	
	public void convertNAdd(String str) {
		int convertedStr = Integer.parseInt(str);
		convertedStr += 10;
		System.out.println(convertedStr);
	}
}