package com.revature.beans;

public class User {
	
	public User() {
		super();
	}
	public User(int id, int isSuper) {
		super();
		this.id = id;
		this.isSuper = isSuper;
	}
	private int id;
	private int isSuper;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIsSuper() {
		return isSuper;
	}
	public void setIsSuper(int isSuper) {
		this.isSuper = isSuper;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", isSuper=" + isSuper + "]";
	}
	
}
