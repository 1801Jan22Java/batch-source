package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BUCKET")
public class Bucket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="BUCKET_ID_SEQUENCE")
	@SequenceGenerator(name="BUCKET_ID_SEQUENCE",sequenceName="BUCKET_ID_SEQUENCE")
	@Column(name="BUCKET_ID")
	private Integer bucketId;
	
	@Column(name="BUCKET_CATEGORY")
	private String bucketCategory;
	
	@Column(name="BUCKET_DESCRIPTION")
	private String bucketDescription;
	
	@Column(name="IS_ACTIVE")
	private Boolean isActive;

	public Bucket(String bucketCategory, String bucketDescription, Boolean isActive) {
		super();
		this.bucketCategory = bucketCategory;
		this.bucketDescription = bucketDescription;
		this.isActive = isActive;
	}

	public Bucket(Integer bucketId, String bucketCategory, String bucketDescription, Boolean isActive) {
		super();
		this.bucketId = bucketId;
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
	
}
