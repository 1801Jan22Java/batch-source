package com.revature.beans;

public class Savings {


	private double savingsBalance;

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public Savings() {
		super();
	}

	public Savings(double savingsBalance) {
		super();
		this.savingsBalance = savingsBalance;
	}

	@Override
	public String toString() {
		return "Savings [savingsBalance=" + savingsBalance + "]";
	}	
	
	
}
