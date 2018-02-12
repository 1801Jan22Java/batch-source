package com.revature.beans;

import java.time.LocalDate;

public class Upload {
	public Upload(String filename, LocalDate creationDate, Employee uploadAuthor) {
		super();
		this.filename = filename;
		this.creationDate = creationDate;
		this.uploadAuthor = uploadAuthor;
	}
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
	public Employee getUploadAuthor() {
		return uploadAuthor;
	}
	@Override
	public String toString() {
		return "Upload [filename=" + filename + ", creationDate=" + creationDate + ", uploadAuthor=" + uploadAuthor
				+ "]";
	}
}
