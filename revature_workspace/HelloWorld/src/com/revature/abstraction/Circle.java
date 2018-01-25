package com.revature.abstraction;

public class Circle implements Shape {
	
	private Double radius;

	@Override
	public Double calculateArea() {
		Double result = 0.0;
		result = Math.PI * (Math.pow(radius, 2));
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calculatePerimeter() {
		// TODO Auto-generated method stub
		Double result = 0.0;
		result = Math.PI * 2 * radius;
		return result;
	}

}
