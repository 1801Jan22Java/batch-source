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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity 
@Table(name="SOFT_SKILL_VIOLATION")
public class SoftSkillViolation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SOFT_SKILL_VIOLATION_SEQUENCE")
	@SequenceGenerator(name="SOFT_SKILL_VIOLATION_SEQUENCE",sequenceName="SOFT_SKILL_VIOLATION_SEQUENCE")
	@Column(name="SOFT_SKILL_VIOLATION_ID")
	private Integer softSkillViolationId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SCREENING_ID")
	private Screening screening;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VIOLATION_TYPE_ID")
	private ViolationType violationType;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME")
	private Date time;
	
	@Column(name="COMMENT")
	private String comment;

	public SoftSkillViolation(Integer softSkillViolationId, Screening screening, ViolationType violationType, Date time,
			String comment) {
		super();
		this.softSkillViolationId = softSkillViolationId;
		this.screening = screening;
		this.violationType = violationType;
		this.time = time;
		this.comment = comment;
	}

	public Integer getSoftSkillViolationId() {
		return softSkillViolationId;
	}

	public void setSoftSkillViolationId(Integer softSkillViolationId) {
		this.softSkillViolationId = softSkillViolationId;
	}

	public Screening getScreening() {
		return screening;
	}

	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	public ViolationType getViolationType() {
		return violationType;
	}

	public void setViolationType(ViolationType violationType) {
		this.violationType = violationType;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
