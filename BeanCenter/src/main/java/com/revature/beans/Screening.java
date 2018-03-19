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
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="screeningSequence")
	@SequenceGenerator(allocationSize=1,name="screeningSequence",sequenceName="SCREENING_S1")
	@Column(name="SCREENING_ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TRAINEE_ID")
	private SimpleTrainee trainee;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SCREENER_ID")
	private Screener screener;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TRACK_ID")
	private Track track;
	
	@Column(name="COMPOSITE_SCORE")
	private Double CompositeScore;
	
	@Column(name="GENERAL_COMMENTARY")
	private String GeneralCommentary;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_TIME")
	private Date dateTime;
	
	@Column(name="VERDICT")
	private String verdict;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SimpleTrainee getTrainee() {
		return trainee;
	}

	public void setTrainee(SimpleTrainee trainee) {
		this.trainee = trainee;
	}

	public Screener getScreener() {
		return screener;
	}

	public void setScreener(Screener screener) {
		this.screener = screener;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Double getCompositeScore() {
		return CompositeScore;
	}

	public void setCompositeScore(Double compositeScore) {
		CompositeScore = compositeScore;
	}

	public String getGeneralCommentary() {
		return GeneralCommentary;
	}

	public void setGeneralCommentary(String generalCommentary) {
		GeneralCommentary = generalCommentary;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getVerdict() {
		return verdict;
	}

	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}
	
}
