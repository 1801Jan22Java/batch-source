package com.revature.beans;

public class TypeLookups {

	//Constructors
	public TypeLookups() {};
	
	public TypeLookups(int typeID, String lookupType) {
		super();
		this.typeID = typeID;
		this.lookupType = lookupType;
	}
	
	//Variables
	private int typeID;
	private String lookupType;
	
	//Getters and Setters
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getLookupType() {
		return lookupType;
	}
	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}
	
}
