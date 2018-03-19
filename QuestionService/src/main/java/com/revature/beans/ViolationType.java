package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="VIOLATION_TYPE")
public class ViolationType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VIOLATION_TYPE_SEQUENCE")
	@SequenceGenerator(name="VIOLATION_TYPE_SEQUENCE",sequenceName="VIOLATION_TYPE_SEQUENCE")
	@Column(name="VIOLATION_TYPE_ID")
	private Integer violationTypeId;
	
	@Column(name="DESCRIPTION")
	private String description;

	public ViolationType(Integer violationTypeId, String description) {
		super();
		this.violationTypeId = violationTypeId;
		this.description = description;
	}

	public Integer getViolationTypeId() {
		return violationTypeId;
	}

	public void setViolationTypeId(Integer violationTypeId) {
		this.violationTypeId = violationTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
