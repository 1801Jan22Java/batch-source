package com.revature.homework1;

/*
 * Write a program to determine if an integer is even without using the modulus operator (%)
 */
public class Question6 {
	private int num;
	
	public Question6() {
		num = 0;
	}
	
	public Question6(int num) {
		this.num = num;
	}
	
	public boolean isEven () {
		
		if(num > 1) {
			if(((num / 2) * 2) < num) // testing for integer truncation
				return false;
			else
				return true;
		}
		else
			return false;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
