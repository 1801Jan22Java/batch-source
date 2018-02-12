package com.revature.beans;

public class BearType {
	public BearType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}
	private int id;
	private String typeName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
