package com.revature.beans;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Trainee implements Serializable {
	private static final long serialVersionUID = -9090223980655307018L;

	private Integer traineeId;
	private String resourceId;
	private String name;
	private String email;
	private TrainingStatus trainingStatus;
	private Batch batch;
	private String phoneNumber;
	private String skypeId;
	private String profileUrl;
	private String recruiterName;
	private String college;
	private String degree;
	private String major;
	private String techScreenerName;
	private String projectCompletion;
	private Set<Grade> grades;
	private Set<Note> notes;
	private Set<Panel> panelInterviews = new TreeSet<>();

	public Trainee() {
		super();
	}

	/**
	 * Constructor used mostly for testing. Default TrainingStatus as Training
	 *
	 * @param name
	 * @param resourceId
	 * @param email
	 * @param batch
	 */
	public Trainee(String name, String resourceId, String email, Batch batch) {
		this();
		this.name = name;
		this.resourceId = resourceId;
		this.email = email;
		this.trainingStatus = TrainingStatus.Training;
		this.batch = batch;
	}

	public Trainee(SimpleTrainee simpleTrainee){
		this();
		this.traineeId = simpleTrainee.getTraineeId();
		this.resourceId = simpleTrainee.getResourceId();
		this.name = simpleTrainee.getName();
		this.email = simpleTrainee.getEmail();
		this.trainingStatus = simpleTrainee.getTrainingStatus();
		this.phoneNumber = simpleTrainee.getPhoneNumber();
		this.skypeId = simpleTrainee.getSkypeId();
		this.profileUrl = simpleTrainee.getProfileUrl();
		this.recruiterName = simpleTrainee.getRecruiterName();
		this.college = simpleTrainee.getCollege();
		this.degree = simpleTrainee.getDegree();
		this.major = simpleTrainee.getMajor();
		this.techScreenerName = simpleTrainee.getTechScreenerName();
		this.projectCompletion = simpleTrainee.getProjectCompletion();
	}

	public Integer getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TrainingStatus getTrainingStatus() {
		return trainingStatus;
	}

	public void setTrainingStatus(TrainingStatus trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public Set<Panel> getPanelInterviews() {
		return panelInterviews;
	}

	public void setPanelInterviews(Set<Panel> panelInterviews) {
		this.panelInterviews = panelInterviews;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((profileUrl == null) ? 0 : profileUrl.hashCode());
		result = prime * result + ((skypeId == null) ? 0 : skypeId.hashCode());
		result = prime * result + ((trainingStatus == null) ? 0 : trainingStatus.hashCode());
		result = prime * result + ((resourceId == null) ? 0 : resourceId.hashCode());
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
		Trainee other = (Trainee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (profileUrl == null) {
			if (other.profileUrl != null)
				return false;
		} else if (!profileUrl.equals(other.profileUrl))
			return false;
		if (skypeId == null) {
			if (other.skypeId != null)
				return false;
		} else if (!skypeId.equals(other.skypeId))
			return false;
		if (trainingStatus != other.trainingStatus)
			return false;
		if (resourceId == null) {
			if (other.resourceId != null)
				return false;
		} else if (!resourceId.equals(other.resourceId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", name=" + name + ", email=" + email + ", trainingStatus="
				+ trainingStatus + ", major=" + major + "]";
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTechScreenerName() {
		return techScreenerName;
	}

	public void setTechScreenerName(String techScreenerName) {
		this.techScreenerName = techScreenerName;
	}

	public String getProjectCompletion() {
		return projectCompletion;
	}

	public void setProjectCompletion(String projectCompletion) {
		this.projectCompletion = projectCompletion;
	}
}
