package com.revature.beans;

import java.io.InputStream;
import java.io.Serializable;

public class Image implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3230022312319598429L;
	
	private InputStream is;

	private int request_id;

	
	
	public Image(InputStream is, int request_id) {
		super();
		this.is = is;
		this.request_id = request_id;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
