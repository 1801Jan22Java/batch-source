package com.revature.homework1;

public class ProblemEighteen extends ProblemEighteen_Super {
	

	public ProblemEighteen() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean upperCase(String moreStuff) {
		boolean has_Uppercase = false;
		for(int i=0; i<= moreStuff.length();i++) {
			if(Character.isUpperCase(moreStuff.charAt(i))) {
				has_Uppercase = true;
			}
			else {
				has_Uppercase= false;
			}
		}
		
		return has_Uppercase;
	}

	@Override
	 String lowerToUpper(String stuff) {
		stuff = stuff.toUpperCase();
		return stuff;
	}

	@Override
	void convert(String number) {
		Integer.parseInt(number);
		System.out.println(number+10);
		
	}
	
	public static void main(String[] args) {
		
		ProblemEighteen_Super la = new ProblemEighteen();
		
		System.out.println(la.lowerToUpper("hello"));
				
	}

}
