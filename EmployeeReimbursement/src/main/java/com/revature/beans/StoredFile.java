package com.revature.beans;


/*
 * A class that holds information regarding any images
 * that are submitted with a reimbursement request.
 */

public class StoredFile {
	
	
	private int fileID;			
	private String fileName;	
	private int requestID;		//The ID of the request that this image is attached to.
	private byte[] imageBytes;	//Used to pass the image data to the servlet from the database.

	
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
	public byte[] getImageBytes() {
		return imageBytes;
	}
	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}
	
	
	
}
