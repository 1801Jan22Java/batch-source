package com.revature.beans;

public class Message {
	
	public Message() {
		super();
	}
	
	public Message(String text) {
		this();
		this.text = text;
	}

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
