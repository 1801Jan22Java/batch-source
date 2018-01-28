package com.revature.homework1;
import java.util.ArrayList;

public class Question9 {

	public static void main(String[] args) {
		
	ArrayList<Integer> num = new ArrayList<Integer>();
	num.add(1);
	num.add(2);
	num.add(60);
	num.add(70);
	num.add(80);
	num.add(90);
	num.add(100);
	for(int i=0; i<num.size(); i++) {
		if(num.size()%2==0) {
			System.out.println(num);
		}
		else {
			System.out.println("This is an odd number");
		}
	}
	
	
	}	
	}

