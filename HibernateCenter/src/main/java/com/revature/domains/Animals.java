package com.revature.domains;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="ANIMALS")
public class Animals implements Serializable{
	

	public Animals() {}
	
	public Animals(String name, String bio, LookupTable maturityL, LookupTable genderL, LookupTable sizeL,
			LookupTable colorL, LookupTable adoptStatusL) {
		super();
		this.name = name;
		this.bio = bio;
		this.maturityL = maturityL;
		this.genderL = genderL;
		this.sizeL = sizeL;
		this.colorL = colorL;
		this.adoptStatusL = adoptStatusL;
	}

	
	public Animals(int animalID, String name, String bio, LookupTable maturityL, LookupTable genderL, LookupTable sizeL,
			LookupTable colorL, LookupTable adoptStatusL) {
		super();
		this.animalID = animalID;
		this.name = name;
		this.bio = bio;
		this.maturityL = maturityL;
		this.genderL = genderL;
		this.sizeL = sizeL;
		this.colorL = colorL;
		this.adoptStatusL = adoptStatusL;
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="animalsSequence")
	@SequenceGenerator(allocationSize=1,name="animalsSequence",sequenceName="SQ_ANIMALS_PK")
	private int animalID; //pk
	@Column(name = "NAME")
	private String name;
	@Column(name = "BIO")
	private String bio;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lookupID")
	private LookupTable maturityL; //fk to lookupID for lookup table
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lookupID")
	private LookupTable genderL; //fk to lookupID for lookup table
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lookupID")
	private LookupTable sizeL; //fk to lookupID for lookup table
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lookupID")
	private LookupTable colorL; //fk to lookupID for lookup table
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lookupID")
	private LookupTable adoptStatusL; //fk to lookupID for lookup table
	
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

	public LookupTable getMaturityL() {
		return maturityL;
	}

	public void setMaturityL(LookupTable maturityL) {
		this.maturityL = maturityL;
	}

	public LookupTable getGenderL() {
		return genderL;
	}

	public void setGenderL(LookupTable genderL) {
		this.genderL = genderL;
	}

	public LookupTable getSizeL() {
		return sizeL;
	}

	public void setSizeL(LookupTable sizeL) {
		this.sizeL = sizeL;
	}

	public LookupTable getColorL() {
		return colorL;
	}

	public void setColorL(LookupTable colorL) {
		this.colorL = colorL;
	}

	public LookupTable getAdoptStatusL() {
		return adoptStatusL;
	}

	public void setAdoptStatusL(LookupTable adoptStatusL) {
		this.adoptStatusL = adoptStatusL;
	}

	@Override
	public String toString() {
		return "Animals [animalID=" + animalID + ", name=" + name + ", bio=" + bio + ", maturityL=" + maturityL + ", genderL="
				+ genderL + ", sizeL=" + sizeL + ", colorL=" + colorL + ", adoptStatusL=" + adoptStatusL + "]";
	}

	
	
}
