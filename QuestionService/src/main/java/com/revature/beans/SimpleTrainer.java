package com.revature.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Simple Trainer.
 */
@Entity
@Table(name = "HYDRA_TRAINER")
@Cacheable
public class SimpleTrainer implements Serializable {
	private static final long serialVersionUID = 4555033024866490022L;

	@Id
	@Column(name = "TRAINER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAINER_ID_SEQUENCE")
	@SequenceGenerator(name = "TRAINER_ID_SEQUENCE", sequenceName = "TRAINER_ID_SEQUENCE")
	@JsonProperty
	private Integer trainerId;
	
	@NotEmpty
	@Column(name = "NAME", nullable = false)
	@JsonProperty
	private String name;

	@NotEmpty
	@Column(name = "TITLE", nullable = false)
	@JsonProperty
	private String title;
	
	@NotEmpty
	@Email
	@Column(name = "EMAIL", nullable = false, unique = true, updatable = true)
	@JsonProperty
	private String email;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "TIER")
	private TrainerRole tier;
	
	@NotEmpty
	@Column(name = "RESUME", nullable = false)
	@JsonProperty
	private String resume;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TRAINER_CERT", joinColumns = @JoinColumn(name = "t_id"), inverseJoinColumns = @JoinColumn(name = "c_id"))
	private List<Certification> certifications;
	
	@ElementCollection(targetClass = Integer.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTable(name = "TRAINER_SKILL", joinColumns = @JoinColumn(name="t_id"))
	@Column(name="SKILL_ID")
	private List<Integer> skillId;

	public SimpleTrainer() {
		super();
	}

	public SimpleTrainer(Integer trainerId, String name, String title, String email, TrainerRole tier, String resume,
			List<Certification> certifications , List<Integer> skillId) {
		super();
		this.trainerId = trainerId;
		this.name = name;
		this.title = title;
		this.email = email;
		this.tier = tier;
		this.resume = resume;
		this.certifications = certifications;
		this.skillId = skillId;
	}


	public SimpleTrainer(Trainer trainer) {
		super();
		this.trainerId = trainer.getTrainerId();
		this.email = trainer.getEmail();
		this.name = trainer.getName();
		this.title = trainer.getTitle();
		this.tier = trainer.getTier();
		this.resume = null;
		this.certifications = null;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public TrainerRole getTier() {
		return tier;
	}

	public void setTier(TrainerRole tier) {
		this.tier = tier;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public List<Integer> getSkillId() {
		return skillId;
	}

	public void setSkillId(List<Integer> skillId) {
		this.skillId = skillId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certifications == null) ? 0 : certifications.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((resume == null) ? 0 : resume.hashCode());
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
		result = prime * result + ((tier == null) ? 0 : tier.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((trainerId == null) ? 0 : trainerId.hashCode());
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
		SimpleTrainer other = (SimpleTrainer) obj;
		if (certifications == null) {
			if (other.certifications != null)
				return false;
		} else if (!certifications.equals(other.certifications))
			return false;
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
		if (resume == null) {
			if (other.resume != null)
				return false;
		} else if (!resume.equals(other.resume))
			return false;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		if (tier != other.tier)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (trainerId == null) {
			if (other.trainerId != null)
				return false;
		} else if (!trainerId.equals(other.trainerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimpleTrainer [trainerId=" + trainerId + ", name=" + name + ", title=" + title + ", email=" + email
				+ ", tier=" + tier + ", resume=" + resume + ", certifications=" + certifications + ", skillId="
				+ skillId + "]";
	}
}