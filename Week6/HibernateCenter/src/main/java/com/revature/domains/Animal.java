package com.revature.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ANIMALS")
@Inheritance(strategy=InheritanceType.JOINED)
public class Animal implements Serializable{
	

	public Animal() {}
	
	public Animal(String name, String bio, List<LookupTable> lookup) {
		super();
		this.animalID = animalID;
		this.name = name;
		this.bio = bio;
	}
	
	public Animal(int animalID, String name, String bio, List<LookupTable> lookup) {
		super();
		this.animalID = animalID;
		this.name = name;
		this.bio = bio;
		this.lookup = lookup;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="animalsSequence")
	@SequenceGenerator(allocationSize=1,name="animalsSequence",sequenceName="SQ_ANIMALS_PK")
	@Column(name="ANIMAL_ID")
	private int animalID; //pk
	@Column(name = "NAME")
	private String name;
	@Column(name = "BIO")
	private String bio;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lookupID")
	private List<LookupTable> lookup; //fk to lookupID for lookup table
	
	public int getAnimalID() {
		return animalID;
	}

	public void setAnimalID(int animalID) {
		this.animalID = animalID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Animal [animalID=" + animalID + ", name=" + name + ", bio=" + bio + ", lookup=" + lookup + "]";
	}
}
