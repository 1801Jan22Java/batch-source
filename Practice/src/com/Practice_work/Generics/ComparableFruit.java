package com.Practice_work.Generics;

public class ComparableFruit implements Comparable <ComparableFruit> {
	private int quantity;
	private String fruitName;
	private String fruitDesc;
	
	public ComparableFruit(String fruitName, String fruitDesc,int quantity) {
		super();
		this.fruitName = fruitName;
		this.fruitDesc = fruitDesc;
		this.quantity = quantity;
	}
	
	
	
	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getFruitName() {
		return fruitName;
	}



	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}



	public String getFruitDesc() {
		return fruitDesc;
	}



	public void setFruitDesc(String fruitDesc) {
		this.fruitDesc = fruitDesc;
	}



	public int compareTo(ComparableFruit compareFruit) {
		
		int compareQuantity = ((ComparableFruit) compareFruit).getQuantity();
		
		return this.quantity - compareQuantity;
		
	}
	
	
}
