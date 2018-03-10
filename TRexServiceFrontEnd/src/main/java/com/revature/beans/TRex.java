package com.revature.beans;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class TRex {

	public TRex(String name, String featherColor) {
		super();
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
