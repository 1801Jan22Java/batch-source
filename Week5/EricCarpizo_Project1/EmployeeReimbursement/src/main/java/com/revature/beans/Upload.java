package com.revature.beans;

import java.io.File;

public class Upload {
	private int id;
	private String filename;
	private int requestId;
	
	public Upload(int id, String filename,int requestId) {
		super();
		this.id = id;
		this.filename = filename;
		this.requestId = requestId;
	}
	
	public Upload(String filename, int requestId) {
		super();
		this.filename = filename;
		this.requestId = requestId;
	}
	
	public Upload() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "Upload [id=" + id + ", filename=" + filename + ", requestId=" + requestId + "]";
	}
}
