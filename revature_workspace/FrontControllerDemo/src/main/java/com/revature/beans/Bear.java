package com.revature.beans;

import java.time.LocalDate;

public class Bear {

	public Bear(String name, Cave cave, BearType bearType, int weight, LocalDate localDate) {
		super();
		this.name = name;
		this.cave = cave;
		this.bearType = bearType;
		this.weight = weight;
		this.birthdate = localDate;
	}

	public Bear(int id, String name, Cave cave, BearType bearType, int weight, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.cave = cave;
		this.bearType = bearType;
		this.weight = weight;
		this.birthdate = birthdate;
	}

	public Bear() {
		super();
	}

	private int id;
	private String name;
	private Cave cave;
	private BearType bearType;
	private int weight;
	private LocalDate birthdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	public BearType getBearType() {
		return bearType;
	}

	public void setBearType(BearType bearType) {
		this.bearType = bearType;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", cave=" + cave + ", bearType=" + bearType + ", weight=" + weight
				+ ", birthdate=" + birthdate + "]";
	}
}