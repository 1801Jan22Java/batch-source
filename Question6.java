package com.revature.homework1;

class Question6{
	
	public static void main(String[] args) {
		int x = -1498988;
		System.out.print(checkParity(x));
	}
	
	static String checkParity(int source) {
		int marker = 0;
		int multiplier;
		if (source < 0)
			multiplier = -1;
		else
			multiplier = 1;
		while (marker * multiplier < source * multiplier) {
			marker += (multiplier * 2);
		}
		if (marker == source)
			return "Even";
		else
			return "Odd";
	}
}