package com.revature.beans;

public class StoredFile {
	
	
	private int fileID;
	private String fileName;
	private int requestID;

	
	public StoredFile() {}
	public StoredFile(int fileID, String fileName, int requestID) {
		super();
		this.fileID = fileID;
		this.fileName = fileName;
		this.requestID = requestID;
	}
	
	
	public int getFileID() {
		return fileID;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	
	
	
}
