package com.revature.beans;

import java.io.Serializable;
import java.util.Date;

public class Grade implements Serializable {
	private static final long serialVersionUID = -2031135710502844800L;

	private Long gradeId;
	private Assessment assessment;
	private Trainee trainee;
	private Date dateReceived;
	private Double score;

	public Grade() {
		super();
	}

	public Grade(Assessment assessment, Trainee trainee, Date dateReceived, Double score) {
		this();
		this.assessment = assessment;
		this.trainee = trainee;
		this.dateReceived = dateReceived;
		this.score = score;
	}

	public Grade(SimpleGrade simpleGrade){
		this();
		this.gradeId = simpleGrade.getGradeId();
		this.dateReceived = simpleGrade.getDateReceived();
		this.score = simpleGrade.getScore();
	}

	public long getGradeId() {
		return gradeId;
	}

	public void setGradeId(long gradeId) {
		this.gradeId = gradeId;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + ((assessment == null) ? 0 : assessment.hashCode());
		result = prime * result + ((dateReceived == null) ? 0 : dateReceived.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((trainee == null) ? 0 : trainee.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		if (assessment == null) {
			if (other.assessment != null)
				return false;
		} else if (!assessment.equals(other.assessment))
			return false;
		if (dateReceived == null) {
			if (other.dateReceived != null)
				return false;
		} else if (!dateReceived.equals(other.dateReceived))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		if (trainee == null) {
			if (other.trainee != null)
				return false;
		} else if (!trainee.equals(other.trainee))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grade [gradeId=" + gradeId + ", assessment=" + assessment + ", trainee=" + trainee + ", dateReceived="
				+ dateReceived + ", score=" + score + "]";
	}
}
