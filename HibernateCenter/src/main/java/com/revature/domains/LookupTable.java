package com.revature.domains;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="LOOKUP")
public class LookupTable implements Serializable{

	public LookupTable() {}
	
	public LookupTable(String columnName, String keyword) {
		super();
		this.columnName = columnName;
		this.keyword = keyword;
	}
	
	public LookupTable(int lookupID, String columnName, String keyword) {
		super();
		this.lookupID = lookupID;
		this.columnName = columnName;
		this.keyword = keyword;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="lookupSequence")
	@SequenceGenerator(allocationSize=1,name="lookupSequence",sequenceName="SQ_LOOKUP_PK")
    @Column(name = "LOOKUP_ID")
	private int lookupID; //pk
    @Column(name = "COLUMN_NAME")
	private String columnName;
	@Column(name="KEYWORD")
	private String keyword;
	
	public int getLookupID() {
		return lookupID;
	}


	public void setLookupID(int lookupID) {
		this.lookupID = lookupID;
	}


	public String getColumnName() {
		return columnName;
	}


	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "LookupTable [lookupID=" + lookupID + ", columnName=" + columnName + ", keyword=" + keyword + "]";
	}
	
}
