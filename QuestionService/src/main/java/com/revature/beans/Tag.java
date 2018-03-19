package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="TAG")
public class Tag {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TAG_SEQUENCE")
	@SequenceGenerator(name="TAG_SEQUENCE",sequenceName="TAG_SEQUENCE")
	@Column(name="TAG_ID")
	private Integer tagId;
	
	@Column(name="TAG_NAME")
	private String tagName;

	public Tag(int tagId, String tagName) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
}
