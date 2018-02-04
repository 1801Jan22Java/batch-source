package com.revature.util;

public class OverDraftException extends Exception {
	private String message = "Overdraft alert. Withdrawing this amount is prohibited.";

	public OverDraftException() {
		super();
	}

	public OverDraftException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public OverDraftException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OverDraftException(String arg0) {
		super(arg0);

	}

	public OverDraftException(Throwable arg0) {
		super(arg0);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
