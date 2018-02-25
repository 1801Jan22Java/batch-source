package com.revature.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name= "ADOPTION_FORMS")
public class AdoptionForms implements Serializable{
	
	public AdoptionForms() {}
	
	public AdoptionForms(Users user, List<Animals> animals) {
		super();
		this.user = user;
		this.animals = animals;
	}
	
	public AdoptionForms(int adoptID, Users user, List<Animals> animals) {
		super();
		this.adoptID = adoptID;
		this.user = user;
		this.animals = animals;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="adoptionFormsSequence")
	@SequenceGenerator(allocationSize=1,name="adoptionFormsSequence",sequenceName="SQ_ADOPTIONFORMS_PK")
	@Column(name="ADOPT_ID")
	private int adoptID; //pk
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
	private Users user; //fk to userID of table Users
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "animalID")
	private List<Animals> animals ; //fk to animalID of table Animals
	
	public int getAdoptID() {
		return adoptID;
	}
	public void setAdoptID(int adoptID) {
		this.adoptID = adoptID;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Animals> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animals> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return "AdoptionForms [adoptID=" + adoptID + ", user=" + user + ", animals=" + animals + "]";
	}
	
	
}
