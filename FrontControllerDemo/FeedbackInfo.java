package com.revature.formatted;

import org.springframework.stereotype.Component;

@Component("feedbackInfo")
public class FeedbackInfo {
	
	private int userId;
	private String message;
	
	public FeedbackInfo() {}
	
	public FeedbackInfo(int userId, String message) {
		this();
		this.userId = userId;
		this.message = message;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
