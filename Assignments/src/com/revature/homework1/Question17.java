package com.revature.homework1;
import java.util.Scanner;
/*
 * Write a program that calculates the simple interest on the principal, rate of interest and
number of years provided by the user. Enter principal, rate and time through the console using
the Scanner class.
Accrued amount = Principal*(1+ Rate* Time)

 */
public class Question17 {
	Scanner scanner = new Scanner(System.in);
	private Double principal;
	private Double rate;
	private Integer time;
	public Double getPrincipal() {
		return principal;
	}
	public void setPrincipal(Double principal) {
		this.principal = principal;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	
	public void doThing() {
		System.out.print("Enter in the principal: $");
		principal = scanner.nextDouble();
		
		System.out.print("Enter in the rate (percent): ");
		rate = scanner.nextDouble();
		rate /= 100; // converting from percent to decimal amount
		
		System.out.print("Enter in the number of years: ");
		time = scanner.nextInt();
		
		System.out.println("Principal = $" + principal);
		System.out.println("Rate = " + rate * 100 + " %");
		System.out.println(time + " years");
		System.out.println("Accrued amount = $" + (principal + (1 + (rate * time))));
		
	}
}
