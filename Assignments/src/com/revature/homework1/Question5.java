package com.revature.homework1;

public class Question5 {
	
	public static String substring(String str, int idx){
		
		StringBuilder builder = new StringBuilder();
		
		
		char[] substringArray = new char[idx-1];
		
		for(int i = 0; i <= idx-1; i++) {
			char character = str.charAt(i) ;
			builder.append( String.valueOf(character) );
			
		}

		str = builder.toString();
		
		
		System.out.println(str);
		return str;
		
	}
	
	public static void main(String[] args) {
		char s = 't' ;
		System.out.println(String.valueOf(s));
		System.out.println(substring("fouurrr", 4));
	}

}
