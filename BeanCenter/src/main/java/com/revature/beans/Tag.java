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
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tagSequence")
	@SequenceGenerator(allocationSize=1,name="tagSequence",sequenceName="TAG_S1")
	@Column(name="TAG_ID")
	private int id;
	
	@Column(name="TAG_NAME")
	String tagName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
}
