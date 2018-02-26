package com.revature.domains;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="USER_FILES")
public class UserFile implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userFilesSequence")
	@SequenceGenerator(allocationSize=1,name="userFilesSequence",sequenceName="SQ_USER_FILES_PK")
    @Column(name = "USER_FILE_ID")
	private int userFileId;
	@OneToOne
	@JoinColumn(name = "userID")
	private User user; //composite pk and fk to uID of users table
	@Column(name="FILENAME")
	private String filename; //composite pk

	public UserFile() {}

	public UserFile(int userFileId, User user, String filename) {
		super();
		this.userFileId = userFileId;
		this.user = user;
		this.filename = filename;
	}

	public int getUserFileId() {
		return userFileId;
	}

	public void setUserFileId(int userFileId) {
		this.userFileId = userFileId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "UserFiles [userFileId=" + userFileId + ", user=" + user + ", filename=" + filename + "]";
	}
}
