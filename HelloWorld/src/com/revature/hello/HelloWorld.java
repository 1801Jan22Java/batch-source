package com.revature.hello;
/*
 * Author: Calvin Milliron
 */
import com.revature.oop.*;
import static com.revature.oop.Cat.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HelloWorld {
	public static void main(String[] args) {
		
		/*
		System.out.println("Hello World");
		new String();
		//without import
		com.revature.oop.Animal a = new com.revature.oop.Animal("Fred");
		//with import
		
		HashMap<Integer, String> b = new HashMap<>();
		b.put(1, "Zello");
		b.put(2, "Hello");

		System.out.println("calculating");
	      Calculator x = null;
	      x.calculate();
		*/
		
		/*
		 5. Balanced Brackets

		 A bracket is any one of the following: (, ), {, }, [, or ]

		 The following are balanced brackets:
		    ()
		    ()()
		    (())
		    ({[]})

		 The following are NOT balanced brackets:
		 (
		 )
		 (()
		 ([)]

		 Return true if balanced
		 Return false if not balanced
		*/
		
		String brackets = "()()()(())({[]})";
		
		for (int i = 0; i < brackets.length(); i++) {
			java.util.ArrayList<String> acceptable = new ArrayList<>();
			switch(brackets.charAt(i)) {
			
			case '(':
				break;
			case ')':
				
				break;
			case '{':
				
				break;
			case '}':
				
				break;
			case '[':
				
				break;
			case ']':
				
				break;
			}
		}
		
		String originalString = "password";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
			System.out.println(bytesToHex(encodedhash));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	
	
}

abstract class Calculator{
	   abstract void calculate();
}


