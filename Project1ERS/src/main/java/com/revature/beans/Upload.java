package com.revature.beans;

import java.time.LocalDate;

public class Upload {
	public Upload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Upload(int uploadId, String displayName, String filename, LocalDate creationDate, Employee uploadAuthor) {
		super();
		this.uploadId = uploadId;
		this.displayName = displayName;
		this.filename = filename;
		this.creationDate = creationDate;
		this.uploadAuthor = uploadAuthor;
	}
	private int uploadId;
	private String displayName;
	private String filename;
	private LocalDate creationDate;
	private Employee uploadAuthor;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public int getUploadId() {
		return uploadId;
	}
	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Employee getUploadAuthor() {
		return uploadAuthor;
	}
	public void setUploadAuthor(Employee uploadAuthor) {
		this.uploadAuthor = uploadAuthor;
	}
	@Override
	public String toString() {
		return "Upload [uploadId=" + uploadId + ", displayName=" + displayName + ", filename=" + filename
				+ ", creationDate=" + creationDate + ", uploadAuthor=" + uploadAuthor + "]";
	}
}
