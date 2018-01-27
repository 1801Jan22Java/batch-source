package com.practice.fileio;

import java.io.Serializable;

public class Cars implements Serializable {
	int number_of_wheels =0;
	private String type;
	private String maker;
	
	public Cars() {
		super();
	}

	public Cars(int number_of_wheels, String type, String maker) {
		super();
		this.number_of_wheels = number_of_wheels;
		this.type = type;
		this.maker = maker;
	}

	public int getNumber_of_wheels() {
		return number_of_wheels;
	}

	public void setNumber_of_wheels(int number_of_wheels) {
		this.number_of_wheels = number_of_wheels;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	@Override
	public String toString() {
		return "Cars [number_of_wheels=" + number_of_wheels + ", type=" + type + ", maker=" + maker + "]";
	}
	
	
	

}
