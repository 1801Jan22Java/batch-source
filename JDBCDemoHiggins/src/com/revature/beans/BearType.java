package com.revature.beans;

public class BearType {

	public BearType(String name) {
		super();
		this.name = name;
	}
	public BearType(int id,String name) {
		super();
		this.id = id;
		this.name =name;
	}
	public BearType() {
		super();
	}
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name =name;
	}
	@Override
	public String toString() {
		return "BearType [id=" + id + ",name=" +name + "]";
	}
	

	
}
