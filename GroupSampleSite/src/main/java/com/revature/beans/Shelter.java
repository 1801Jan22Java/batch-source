package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name="SHELTER")
public class Shelter {


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="shelterSequence")
	@SequenceGenerator(allocationSize=1,name="shelterSequence", sequenceName="SQ_SHELTER_PK" )
	@Column(name="SHELTER_ID")
	private int shelterId;

	@Column(name="NAME")
	private String name;


	public Shelter(int shelterId, String name) {
		super();
		this.shelterId = shelterId;
		this.name = name;
	}
	
	public Shelter(String name) {

		super();

		this.name = name;

	}

	public Shelter() {

		super();
		
	}
	
	public int getShelterId() {

		return shelterId;

	}

	public void setShelterId(int shelterId) {

		this.shelterId = shelterId;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	@Override

    public String toString() {

        return "Shelter [id=" + shelterId + ", name=" + name + "]";

    }
}
