package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tRex")
@Scope("prototype")
@Entity
@Table(name="T_REX")
public class TRex {

	public TRex(String name, String featherColor) {
		super();
		this.name = name;
		this.featherColor = featherColor;
	}
	public TRex() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tRexSequence")
	@SequenceGenerator(allocationSize=1,name="tRexSequence",sequenceName="SQ_T_REX_PK")
	@Column(name="T_REX_ID")
	private int id;
	@Column(name="T_REX_NAME")
	private String name;
	@Column(name="T_REX_FEATHER_COLOR")
	private String featherColor;
	
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
	public String getFeatherColor() {
		return featherColor;
	}
	public void setFeatherColor(String featherColor) {
		this.featherColor = featherColor;
	}
	@Override
	public String toString() {
		return "TRex [id=" + id + ", name=" + name + ", featherColor=" + featherColor + "]";
	}
	
}
