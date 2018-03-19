package com.revature.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Batch implements Serializable {
	private static final long serialVersionUID = -5755409643112884001L;

	private Integer batchId;
	private String resourceId;
	private String trainingName;
	private Trainer trainer;
	private Trainer coTrainer;
	private SkillType skillType;
	private TrainingType trainingType;
	private Date startDate;
	private Date endDate;
	private String location;
	private Address address;
	private Short goodGradeThreshold;
	private Short borderlineGradeThreshold;
	private Set<Trainee> trainees;
	private Integer weeks;
	private Integer gradedWeeks;
	private Set<Note> notes;

	public Batch() {
		super();
		this.weeks = 1;
		this.gradedWeeks = 7;
		this.goodGradeThreshold = 80;
		this.borderlineGradeThreshold = 70;
		this.trainingType = TrainingType.Revature;
		this.trainees = new HashSet<>();
		this.notes = new HashSet<>();
	}

	/**
	 * Constructor mostly used for testing. Defaults TrainingType - Revature,
	 * SkillType - J2EE, Good grade - 80, and Borderline grade - 70
	 *
	 * @param trainingName
	 * @param trainer
	 * @param startDate
	 * @param endDate
	 * @param location
	 */
	public Batch(String trainingName, Trainer trainer, Date startDate, Date endDate, String location) {
		this();
		this.trainingName = trainingName;
		this.trainer = trainer;
		this.skillType = SkillType.J2EE;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
	}

	public Batch(SimpleBatch simpleBatch) {
		super();
		this.batchId = simpleBatch.getBatchId();
		this.resourceId = simpleBatch.getResourceId();
		this.trainingName = simpleBatch.getTrainingName();
		this.skillType = simpleBatch.getSkillType();
		this.startDate = simpleBatch.getStartDate();
		this.endDate = simpleBatch.getEndDate();
		this.location = simpleBatch.getLocation();
		this.goodGradeThreshold = simpleBatch.getGoodGradeThreshold();
		this.borderlineGradeThreshold = simpleBatch.getBorderlineGradeThreshold();
		this.weeks = simpleBatch.getWeeks();
		this.gradedWeeks = simpleBatch.getGradedWeeks();
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Trainer getCoTrainer() {
		return coTrainer;
	}

	public void setCoTrainer(Trainer coTrainer) {
		this.coTrainer = coTrainer;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public TrainingType getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Short getGoodGradeThreshold() {
		return goodGradeThreshold;
	}

	public void setGoodGradeThreshold(Short goodGradeThreshold) {
		this.goodGradeThreshold = goodGradeThreshold;
	}

	public Short getBorderlineGradeThreshold() {
		return borderlineGradeThreshold;
	}

	public void setBorderlineGradeThreshold(Short borderlineGradeThreshold) {
		this.borderlineGradeThreshold = borderlineGradeThreshold;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}

	public Integer getWeeks() {
		return weeks;
	}

	public void setWeeks(Integer weeks) {
		this.weeks = weeks;
	}

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getGradedWeeks() {
		return gradedWeeks;
	}

	public void setGradedWeeks(Integer gradedWeeks) {
		this.gradedWeeks = gradedWeeks;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + borderlineGradeThreshold;
		result = prime * result + ((coTrainer == null) ? 0 : coTrainer.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + goodGradeThreshold;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((skillType == null) ? 0 : skillType.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
		result = prime * result + ((trainingName == null) ? 0 : trainingName.hashCode());
		result = prime * result + ((trainingType == null) ? 0 : trainingType.hashCode());
		result = prime * result + ((resourceId == null) ? 0 : resourceId.hashCode());
		result = prime * result + weeks;
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
		Batch other = (Batch) obj;
		if (borderlineGradeThreshold != other.borderlineGradeThreshold)
			return false;
		if (coTrainer == null) {
			if (other.coTrainer != null)
				return false;
		} else if (!coTrainer.equals(other.coTrainer))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (goodGradeThreshold != other.goodGradeThreshold)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (skillType != other.skillType)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		if (trainingName == null) {
			if (other.trainingName != null)
				return false;
		} else if (!trainingName.equals(other.trainingName))
			return false;
		if (resourceId == null) {
			if (other.resourceId != null)
				return false;
		} else if (!resourceId.equals(other.resourceId))
			return false;
		if (trainingType != other.trainingType)
			return false;
		if (weeks != other.weeks)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", trainingName=" + trainingName + ", skillType=" + skillType
				+ ", trainingType=" + trainingType + ", location==" + location + "]";
	}

}
