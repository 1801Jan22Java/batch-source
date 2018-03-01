package com.revature.beans;

public class TRex {

	public TRex(int id, String name, String featherColor) {
		super();
		this.id = id;
		this.name = name;
		this.featherColor = featherColor;
	}
	public TRex() {
		super();
	}
	private int id;
	private String name;
	private String featherColor;
	
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
		this.name = name;
	}
	public String getFeatherColor() {
		return featherColor;
	}
	public void setFeatherColor(String featherColor) {
		this.featherColor = featherColor;
	}
	@Override
	public String toString() {
		return "TRex [id=" + id + ", name=" + name + ", featherColor=" + featherColor + "]";
	}
	
}
