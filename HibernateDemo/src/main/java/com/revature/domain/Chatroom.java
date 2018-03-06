package com.revature.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
@Table(name = "CHATROOM")
public class Chatroom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5270792410693597382L;

	public Chatroom(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Chatroom(String name) {
		super();
		this.name = name;
	}

	public Chatroom() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ChatroomSequence")
	@SequenceGenerator(allocationSize = 1, name = "ChatroomSequence", sequenceName = "SQ_Chatroom_PK")
	@Column(name = "ID")
	private int id;

	@Column(name = "CHATROOM_NAME", length = 50)
	private String name;

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

	@Override
	public String toString() {
		return "CHATROOM [id=" + id + ", name=" + name + "]";
	}
}
