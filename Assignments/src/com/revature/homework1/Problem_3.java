package com.revature.homework1;

public class Problem_3 {
	public static String Flippy_Floppy(String flop) {
		String flip = "";
			for(int i = flop.length() -1; i>=0; i--) {
				flip = flip+ flop.charAt(i);
			}
			return flip;
	}

	public static void main(String args[]) {
		System.out.print(Flippy_Floppy("Hello_World"));

	}

}
