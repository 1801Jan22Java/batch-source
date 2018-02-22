package com.revature.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="WHALE_LOOKUP")
public class WhaleLookup implements Serializable{

	private static final long serialVersionUID = -625830368471629930L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="entrySequence")
	@SequenceGenerator(allocationSize=1,name="entrySequence",sequenceName="SQ_ENTRY_PK")
	@Column(name="ENTRY_ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private int userId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="WHALE_ID")
	private int whaleId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getWhaleId() {
		return whaleId;
	}

	public void setWhaleId(int whaleId) {
		this.whaleId = whaleId;
	}

	public WhaleLookup(int id, int userId, int whaleId) {
		super();
		this.id = id;
		this.userId = userId;
		this.whaleId = whaleId;
	}

	public WhaleLookup(int userId, int whaleId) {
		super();
		this.userId = userId;
		this.whaleId = whaleId;
	}

	public WhaleLookup() {
		super();
	}
	
	
}
