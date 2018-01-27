package com.revature.question11config;

/**
 * Created by: Jeffrey Rubi Date: 26 January 2018 
 * Write a program that would access two float-variables from a class that exists in another package. Note, 
 * you will need to create two packages to demonstrate the solution.
 */

public final class Question11OtherClass {
	
	public float var1 = 314159; // Pi
	public float var2 = 1618033; // Golden ratio

	public Question11OtherClass() {
		super();
	}

	public Question11OtherClass(float var1, float var2) {
		super();
		this.var1 = var1;
		this.var2 = var2;
	}

	public float getVar1() {
		return var1;
	}

	public void setVar1(float var1) {
		this.var1 = var1;
	}

	public float getVar2() {
		return var2;
	}

	public void setVar2(float var2) {
		this.var2 = var2;
	}

	@Override
	public String toString() {
		return "Question11OtherClass [floatVar1 = " + var1 + ", floatVar2 = " + var2 + "]";
	}

}
