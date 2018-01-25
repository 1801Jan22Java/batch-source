package com.revature.homework1;

import java.util.Random;

public class Question15 {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		Random rand = new Random();
		
		double x;
		double y;
		
		//String.format("%f + %f = %f", x, y, calc.add(x, y))
		
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f + %.2f = %.2f", x, y, calc.add(x, y)));
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f + %.2f = %.2f", x, y, calc.add(x, y)));
		
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f - %.2f = %.2f", x, y, calc.subtract(x, y)));
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f - %.2f = %.2f", x, y, calc.subtract(x, y)));
		
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f * %.2f = %.2f", x, y, calc.multiply(x, y)));
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f * %.2f = %.2f", x, y, calc.multiply(x, y)));
		
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		
		while(y == 0.0) {
			y = rand.nextInt(100);
		}
		
		System.out.println(String.format("%.2f / %.2f = %.2f", x, y, calc.divide(x, y)));
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		
		while(y == 0.0) {
			y = rand.nextInt(100);
		}
		
		System.out.println(String.format("%.2f / %.2f = %.2f", x, y, calc.divide(x, y)));
		
		
		
	}

}
