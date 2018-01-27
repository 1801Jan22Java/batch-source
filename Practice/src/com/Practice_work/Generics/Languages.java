package com.Practice_work.Generics;

import java.util.Comparator;

public class Languages implements Comparable<Languages> {
	private String name;
	private String common_country;
	
	public Languages() {
		super();
	}
	
	public Languages(String name, String common_nationality) {
		super();
		this.name = name;
		this.common_country = common_nationality;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommon_country() {
		return common_country;
	}

	public void setCommon_country(String common_country) {
		this.common_country = common_country;
	}

	@Override
	public String toString() {
		return "Languages [name=" + name + ", common_country=" + common_country + "]";
	}

	@Override
	public int compareTo(Languages l) {
		// TODO Auto-generated method stub
		
		return this.getName().compareTo(l.getName());
		
	}
	
	

}

class SortBycountry implements Comparator<Languages>{

	@Override
	public int compare(Languages o1, Languages o2) {
		// TODO Auto-generated method stub
		return o1.getCommon_country().compareTo(o2.getCommon_country());
	}
	
}
