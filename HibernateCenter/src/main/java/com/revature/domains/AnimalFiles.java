package com.revature.domains;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="ANIMAL_FILES")
public class AnimalFiles implements Serializable {

	public AnimalFiles() {}
	
	public AnimalFiles(int aniFilesID, Animals animal, String filename) {
		super();
		this.aniFilesID = aniFilesID;
		this.animal = animal;
		this.filename = filename;
	}
	
	public AnimalFiles(Animals animal, String filename) {
		super();
		this.animal = animal;
		this.filename = filename;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="animalFilesSequence")
	@SequenceGenerator(allocationSize=1,name="animalFilesSequence",sequenceName="SQ_ANIMALFILES_PK")
	@Column(name="ANI_FILES_ID")
	private int aniFilesID; //pk
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "animalID")
	private Animals animal; //fk to aID of table animals
	@Column(name = "FILENAME")
	private String filename;
	
	public int getAniFilesID() {
		return aniFilesID;
	}

	public void setAniFilesID(int aniFilesID) {
		this.aniFilesID = aniFilesID;
	}

	public Animals getAnimal() {
		return animal;
	}

	public void setAnimal(Animals animal) {
		this.animal = animal;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilenames(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "AnimalFiles [aniFilesID=" + aniFilesID + ", animal=" + animal + ", filename=" + filename + "]";
	} 
	
	
	

	
}
