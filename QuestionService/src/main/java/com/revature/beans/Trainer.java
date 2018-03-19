package com.revature.beans;

import java.io.Serializable;
import java.util.Set;

public class Trainer implements Serializable {
	private static final long serialVersionUID = -2546407792912483570L;

	private Integer trainerId;
	private String name;
	private String title;
	private String email;
	private TrainerRole tier;
	private Set<Batch> batches;

	public Trainer() {
		super();
	}

	public Trainer(String name, String title, String email, TrainerRole tier) {
		this();
		this.name = name;
		this.title = title;
		this.email = email;
		this.tier = tier;
	}

	public Trainer(SimpleTrainer simpleTrainer){
		this();
		this.trainerId = simpleTrainer.getTrainerId();
		this.name = simpleTrainer.getName();
		this.title = simpleTrainer.getTitle();
		this.email = simpleTrainer.getEmail();
		this.tier = simpleTrainer.getTier();
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TrainerRole getTier() {
		return tier;
	}

	public void setTier(TrainerRole tier) {
		this.tier = tier;
	}

	public Set<Batch> getBatches() {
		return batches;
	}

	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tier == null) ? 0 : tier.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Trainer other = (Trainer) obj;
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
		if (tier != other.tier)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", name=" + name + ", title=" + title + ", email=" + email
				+ ", tier=" + tier + "]";
	}

}
