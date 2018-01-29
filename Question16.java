package com.revature.homework1;

class Question16{
	
	public static void main(String[] args) {
		try {
		System.out.println(args[0].length());
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Usage: java Question16 [Input]");
		}
	}
}