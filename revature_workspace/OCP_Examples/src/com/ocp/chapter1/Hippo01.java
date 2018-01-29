package com.ocp.chapter1;

public class Hippo01 {
	private String name;
	private double weight;
	
	public Hippo01(String name, double weight){
		this.name = name;
		this.weight=weight;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
	public static void main(String [] args)
	{
		Hippo01 h1=  new Hippo01("Harry",3100);
		System.out.println(h1);
	}
}
