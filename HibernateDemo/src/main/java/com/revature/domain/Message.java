package com.revature.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * @author jacob
 *
 */
@Entity
@Table(name = "MESSAGE")
public class Message implements Serializable, Comparable<Message> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MessageSequence")
	@SequenceGenerator(allocationSize = 1, name = "MessageSequence", sequenceName = "SQ_MESSAGE_PK")
	@Column(name = "ANIMAL_ID")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROOM_ID")
	private Chatroom room;

	@Column(name = "MESSAGE", length = 1000)
	private String message;

	@Column(name = "DATE_CREATED")
	private LocalDateTime date;

	@Column(name = "IMAGE_URL", length = 1500)
	private String imageURL;
	
	public Message(int id, User user, Chatroom room, String message,
			LocalDateTime date, String imageURL) {
		super();
		this.id = id;
		this.user = user;
		this.room = room;
		this.message = message;
		this.date = date;
		this.imageURL = imageURL;
	}

	public Message(User user, Chatroom room, String message,
			LocalDateTime date, String imageURL) {
		super();
		this.user = user;
		this.room = room;
		this.message = message;
		this.date = date;
		this.imageURL = imageURL;
	}

	public Message() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUserId(User user) {
		this.user = user;
	}

	public Chatroom getRoomId() {
		return room;
	}

	public void setRoomId(Chatroom room) {
		this.room = room;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", user=" + user + ", room=" + room
				+ ", message=" + message + ", date=" + date + ", imageURL="
				+ imageURL + "]";
	}

	@Override
	public int compareTo(Message arg0) {
		return this.date.compareTo(arg0.date);
	}

}
