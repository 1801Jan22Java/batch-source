package com.revature.abstraction;
import java.lang.*;

public abstract class Circle implements Shape{

	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Double radius;

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	@Override
	public Double calculateArea() {
		return Math.PI*radius*radius;	//No need to use this.radius here, since no shadowing.
	}

	@Override
	public Double calculatePerimeter() {
		return 2*Math.PI*radius;
	}
	
	
}
