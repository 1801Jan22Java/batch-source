package com.revature.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name= "ADOPTION_FORMS")
public class AdoptionForm implements Serializable{
	
	public AdoptionForm() {}
	
	public AdoptionForm(User user, List<Animal> animals) {
		super();
		this.user = user;
		this.animals = animals;
	}
	
	public AdoptionForm(int adoptionFormID, User user, List<Animal> animals) {
		super();
		this.adoptionFormID = adoptionFormID;
		this.user = user;
		this.animals = animals;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="adoptionFormsSequence")
	@SequenceGenerator(allocationSize=1,name="adoptionFormsSequence",sequenceName="SQ_ADOPTIONFORMS_PK")
	@Column(name="ADOPTION_ID")
	private int adoptionFormID; //pk
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
	private User user; //fk to userID of table Users
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "animalID")
	private List<Animal> animals ; //fk to animalID of table Animals
	
	public int getAdoptionFormID() {
		return adoptionFormID;
	}
	public void setAdoptionFormID(int adoptionFormID) {
		this.adoptionFormID = adoptionFormID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return "AdoptionForms [adoptionFormID=" + adoptionFormID + ", user=" + user + ", animals=" + animals + "]";
	}
	
	
}
