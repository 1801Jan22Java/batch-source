package com.revature.caliber.model;

import java.io.Serializable;

public class Bucket implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer bucketId;
	private String bucketCategory;
	private String bucketDescription;
	private Boolean isActive;
	
	public Bucket() {
		super();
	}
	
	public Bucket(Integer bucketId, String bucketCategory, String bucketDescription, Boolean isActive) {
		super();
		this.bucketId = bucketId;
		this.bucketCategory = bucketCategory;
		this.bucketDescription = bucketDescription;
		this.isActive = isActive;
	}
	
	public Bucket(String bucketCategory, String bucketDescription, Boolean isActive) {
		super();
		this.bucketCategory = bucketCategory;
		this.bucketDescription = bucketDescription;
		this.isActive = isActive;
	}

	public Integer getBucketId() {
		return bucketId;
	}

	public void setBucketId(Integer bucketId) {
		this.bucketId = bucketId;
	}

	public String getBucketCategory() {
		return bucketCategory;
	}

	public void setBucketCategory(String bucketCategory) {
		this.bucketCategory = bucketCategory;
	}

	public String getBucketDescription() {
		return bucketDescription;
	}

	public void setBucketDescription(String bucketDescription) {
		this.bucketDescription = bucketDescription;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Bucket [bucketId=" + bucketId + ", bucketCategory=" + bucketCategory + ", bucketDescription="
				+ bucketDescription + ", isActive=" + isActive + "]";
	}
	
}
