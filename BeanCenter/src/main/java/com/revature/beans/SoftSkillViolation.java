package com.revature.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity 
@Table(name="SOFT_SKILL_VIOLATION")
public class SoftSkillViolation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="softSkillViolationSequence")
	@SequenceGenerator(allocationSize=1,name="softSkillViolationSequence",sequenceName="SOFT_SKILL_VIOLATION_S1")
	@Column(name="SOFT_SKILL_VIOLATION_ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SCREENING_ID")
	private Screening screening;
	
	@Column(name="VIOLATION")
	private String violation;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME")
	private Date Time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Screening getScreening() {
		return screening;
	}

	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	public String getViolation() {
		return violation;
	}

	public void setViolation(String violation) {
		this.violation = violation;
	}

	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) {
		Time = time;
	}
	
}
