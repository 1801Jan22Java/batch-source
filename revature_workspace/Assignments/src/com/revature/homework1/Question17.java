package com.revature.homework1;
/*
 * Q17. Write a program that calculates the simple interest on the principal, 
 * rate of interest and number of years provided by the user. Enter principal, 
 * rate and time through the console using the Scanner class.
Accrued amount = Principal*(1+ Rate* Time)

 * 
 * Question17 class takes in three parameters: float rate, int numYears, float principal
 * */
public class Question17 {

	private float rate;
	private int numYears;
	private float principal;
	
	
	/*
	 * Constructor for Question17 class
	 * We instantiate Question17 class by taking in the three parameters
	 * int numYears, float principal, float rate
	 * */
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
	
	/*
	 * public float calculateInterest() returns float interest.
	 * the rate field is multiplied by .01f to be treated as a percentage of the principal
	 * getPrincipal() is then multiplied by getNumYears() and decimalRate to get interest
	 * @param none
	 * @return float interest
	 * */
	public float calculateInterest()
	{
		float interest =0.0f;
		float decimalRate = getRate()*.01f;
		interest = getNumYears()*getPrincipal()*decimalRate;
		return interest;
	}
	/*
	 * displays the principal, number of years, rate, and simple interest is displayed as a string
	 * @param none
	 * @return none
	 * */
	
	public void displayInterest()
	{
		System.out.println("The simple interest for a principal of " +getPrincipal() +" over " + getNumYears() + " years "+
	"at a rate of " + getRate() + " is " + calculateInterest());
	}
	/*
	 * Verifies that the input can be parsed into a rate. 
	 * Complains if input causes a NumberFormatException
	 * if valid, calls setRate()
	 * @param input String
	 * @return boolean result
	 * */
	public boolean verifyRateFloat(String input)
	{
		boolean result =false;
		try{
		Float rate = Float.parseFloat(input);
		setRate(rate);
		result = true;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid number");
		}
		finally
		{
			return result;
		}
	}
	/* Verifies that the input can be parsed into a number of years. 
	 * Complains if input causes a NumberFormatException
	 * If valid, calls setNumYears()
	 * @param String input
	 * @return boolean result
	 * */
	public boolean verifyYearInt(String input)
	{
		boolean result=false;
		try{
		Integer years = Integer.parseInt(input);
		setNumYears(years);
		result=true;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid number");
		}
		finally
		{
			return result;
		}
	}
	/*
	 * Verifies that the input can be parsed into a principal balance. 
	 * Complains if input causes a NumberFormatException
	 * If valid, calls setPrincipal()
	 * @param input String
	 * @return boolean result
	 * */
	public boolean verifyPrincipalFloat(String input)
	{
		boolean result = false;
		try{
		Float principal = Float.parseFloat(input);
		setPrincipal(principal);
		result=true;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid number");
		}
		finally{
			return result;
		}
	}
	
	

}
