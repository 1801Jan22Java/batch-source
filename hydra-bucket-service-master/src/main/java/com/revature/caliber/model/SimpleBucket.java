package com.revature.caliber.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity 
@Table(name="BUCKET")
@Cacheable
public class SimpleBucket  implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BUCKET_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="BUCKET_ID_SEQUENCE")
	@SequenceGenerator(name="BUCKET_ID_SEQUENCE",sequenceName="BUCKET_ID_SEQUENCE")
	private Integer bucketId;
	
	@NotEmpty
	@Column(name="BUCKET_CATEGORY", nullable = false)
	private String bucketCategory;
	
	@Column(name="BUCKET_DESCRIPTION")
	private String bucketDescription;
	
	@Column(name="IS_ACTIVE", nullable = false)
	private Boolean isActive;
	
	public SimpleBucket() {
		super();
	}
	
	public SimpleBucket(Bucket bucket) {
		super();
		this.bucketCategory = bucket.getBucketCategory();
		this.bucketDescription = bucket.getBucketDescription();
		this.isActive = bucket.getIsActive();
	}
	
	public SimpleBucket(Integer bucketId, String bucketCategory, String bucketDescription, Boolean isActive) {
		super();
		this.bucketId = bucketId;
		this.bucketCategory = bucketCategory;
		this.bucketDescription = bucketDescription;
		this.isActive = isActive;
	}

	public SimpleBucket(String bucketCategory, String bucketDescription, Boolean isActive) {
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

	@Override
	public String toString() {
		return "Bucket [bucketId=" + bucketId + ", bucketCategory=" + bucketCategory + ", bucketDescription="
				+ bucketDescription + ", isActive=" + isActive + "]";
	}
}
