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
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bucketSequence")
	@SequenceGenerator(allocationSize=1,name="bucketSequence",sequenceName="BUCKET_S1")
	@Column(name="BUCKET_ID")
	private Integer id;
	
	@Column(name="BUCKET_CATEGORY")
	private String bucketCategory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBucketCategory() {
		return bucketCategory;
	}

	public void setBucketCategory(String bucketCategory) {
		this.bucketCategory = bucketCategory;
	}
	
}
