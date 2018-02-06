package com.revature.beans;

public class Checkings {

	private double checkingsBalance;

	public double getCheckingsBalance() {
		return checkingsBalance;
	}

	public void setCheckingsBalance(double checkingsBalance) {
		this.checkingsBalance = checkingsBalance;
	}

	public Checkings() {
		super();
	}

	public Checkings(double checkingsBalance) {
		super();
		this.checkingsBalance = checkingsBalance;
	}

	@Override
	public String toString() {
		return "Checkings [checkingsBalance=" + checkingsBalance + "]";
	}
	
}
