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
@Table(name="SCREENING")
public class Screening {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SCREENING_SEQUENCE")
	@SequenceGenerator(name="SCREENING_SEQUENCE",sequenceName="SCREENING_SEQUENCE")
	@Column(name="SCREENING_ID")
	private Integer screeningId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TRAINEE_ID")
	private SimpleTrainee trainee;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TRAINER_ID")
	private SimpleTrainer trainer;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TRACK_ID")
	private Track track;
	
	@Column(name="COMPOSITE_SCORE")
	private Double compositeScore;
	
	@Column(name="ABOUT_ME_COMMENTARY")
	private String aboutMeCommentary;
	
	@Column(name="GENERAL_COMMENTARY")
	private String generalCommentary;
	
	@Column(name="SOFT_SKILL_COMMENTARY")
	private String softSkillCommentary;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_DATE_TIME")
	private Date startDateTime;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_DATE_TIME")
	private Date endDateTime;
	
	@Column(name="SOFT_SKILLS_VERDICT")
	private String softSkillsVerdict;
	
	@Column(name="STATUS")
	private Status status;

	public Screening(Integer screeningId, SimpleTrainee trainee, SimpleTrainer trainer, Track track,
			Double compositeScore, String aboutMeCommentary, String generalCommentary, String softSkillCommentary,
			Date startDateTime, Date endDateTime, String softSkillsVerdict, Status status) {
		super();
		this.screeningId = screeningId;
		this.trainee = trainee;
		this.trainer = trainer;
		this.track = track;
		this.compositeScore = compositeScore;
		this.aboutMeCommentary = aboutMeCommentary;
		this.generalCommentary = generalCommentary;
		this.softSkillCommentary = softSkillCommentary;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
	}

	public Integer getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(Integer screeningId) {
		this.screeningId = screeningId;
	}

	public SimpleTrainee getTrainee() {
		return trainee;
	}

	public void setTrainee(SimpleTrainee trainee) {
		this.trainee = trainee;
	}

	public SimpleTrainer getTrainer() {
		return trainer;
	}

	public void setTrainer(SimpleTrainer trainer) {
		this.trainer = trainer;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Double getCompositeScore() {
		return compositeScore;
	}

	public void setCompositeScore(Double compositeScore) {
		this.compositeScore = compositeScore;
	}

	public String getAboutMeCommentary() {
		return aboutMeCommentary;
	}

	public void setAboutMeCommentary(String aboutMeCommentary) {
		this.aboutMeCommentary = aboutMeCommentary;
	}

	public String getGeneralCommentary() {
		return generalCommentary;
	}

	public void setGeneralCommentary(String generalCommentary) {
		this.generalCommentary = generalCommentary;
	}

	public String getSoftSkillCommentary() {
		return softSkillCommentary;
	}

	public void setSoftSkillCommentary(String softSkillCommentary) {
		this.softSkillCommentary = softSkillCommentary;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getSoftSkillsVerdict() {
		return softSkillsVerdict;
	}

	public void setSoftSkillsVerdict(String softSkillsVerdict) {
		this.softSkillsVerdict = softSkillsVerdict;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
