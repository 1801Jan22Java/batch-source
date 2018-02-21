package com.revature.beans;

public class Lookup {

	
	public Lookup(int lookupID, String keyword) {
		super();
		this.lookupID = lookupID;
		this.keyword = keyword;
	}
	
	private int lookupID;
	private String keyword;
	
	public int getLookupID() {
		return lookupID;
	}
	public void setLookupID(int lookupID) {
		this.lookupID = lookupID;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Lookup [lookupID=" + lookupID + ", keyword=" + keyword + "]";
	}
	
}
