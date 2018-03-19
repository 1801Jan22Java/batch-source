package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="TRACK")
public class Track {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="trackSequence")
	@SequenceGenerator(allocationSize=1,name="trackSequence",sequenceName="TRACK_S1")
	@Column(name="TRACK_ID")
	private Integer id;
	
	@Column(name="CURRICULUM")
	String curriculum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	
}
