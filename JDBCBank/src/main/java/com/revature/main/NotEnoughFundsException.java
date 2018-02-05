package com.revature.main;

//Fires if not enough funds are within an account that is withdrawn from
public class NotEnoughFundsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6685648775919479926L;

	public NotEnoughFundsException() {
		// TODO Auto-generated constructor stub
	}

	public NotEnoughFundsException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NotEnoughFundsException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NotEnoughFundsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public NotEnoughFundsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
