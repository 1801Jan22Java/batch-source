package com.practice.fileio;

import java.io.Serializable;

public class Stores implements Serializable {
	private int number_of_stores;
	private String store_name;
	private String store_goods;
	
	public Stores() {
		super();
		
	}
	
	public Stores(int number_of_stores,String store_name, String store_goods) {
		super();
		this.number_of_stores = number_of_stores;
		this.store_name = store_name;
		this.store_goods = store_goods;
		
	
	}

	public int getNumber_of_stores() {
		return number_of_stores;
	}

	public void setNumber_of_stores(int number_of_stores) {
		this.number_of_stores = number_of_stores;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_goods() {
		return store_goods;
	}

	public void setStore_goods(String store_goods) {
		this.store_goods = store_goods;
	}

	@Override
	public String toString() {
		return "Stores [number_of_stores=" + number_of_stores + ", store_name=" + store_name + ", store_goods="
				+ store_goods + "]";
	}
	
	

}
