package com.revature.homework1;
/*
 * Q17. Write a program that calculates the simple interest on the principal, 
 * rate of interest and number of years provided by the user. Enter principal, 
 * rate and time through the console using the Scanner class.
Accrued amount = Principal*(1+ Rate* Time)

 * 
 * */
public class Question17 {
	
	private float rate;
	private int numYears;
	private float principal;
	
	public Question17( int numYears, float principal,float rate) {
		super();
		
		this.numYears = numYears;
		this.principal = principal;
		this.rate = rate;
		
	}
	
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getNumYears() {
		return numYears;
	}
	public void setNumYears(int numYears) {
		this.numYears = numYears;
	}
	public Question17() {
		super();
		// TODO Auto-generated constructor stub
	}
	public float getPrincipal() {
		return principal;
	}
	public void setPrincipal(float principal) {
		this.principal = principal;
	}
	
	public float calculateInterest()
	{
		float interest =0.0f;
		float decimalRate = getRate()*.01f;
		interest = getNumYears()*getPrincipal()*decimalRate;
		return interest;
	}
	
	public void displayInterest()
	{
		System.out.println("The simple interest for a principal of " +getPrincipal() +" over " + getNumYears() + " years"+
	"at a rate of " + getRate() + " is " + calculateInterest());
	}
	

}
