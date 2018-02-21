package com.revature.beans;

public class Files {

	
	public Files(int fileID, String fileName, int requestID, String fileURL) {
		super();
		this.fileID = fileID;
		this.fileName = fileName;
		this.requestID = requestID;
		this.fileURL = fileURL;
	}
	
	private int fileID;
	private String fileName;
	private int requestID;
	private String fileURL;
	
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
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	@Override
	public String toString() {
		return "Files [fileID=" + fileID + ", fileName=" + fileName + ", requestID=" + requestID + ", fileURL=" + fileURL + "]";
	}
	
	
}
