package com.revature.InClass;

import java.util.function.Predicate;

interface LambdaInterface {
	int lambdaInt(int a, int b, int c);
}

public class Lambda {
	
	public static void main(String[] args) {
		LambdaInterface l = (x,y,z) ->{ for(int i = x; i < y; i += z) {System.out.println(i); }return y + 1;};
		
		System.out.println(l.lambdaInt(0, 5, 1));
		
		Predicate<Integer> p = i -> i < 10;//
	}

}
