package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Documents implements Comparable<Documents> {
	@Id
	@Column(name="fid",length=10)
	private int fileId;
	@Column(name="fname",length=100)
	private String fileName;
	@Column(name="fdata")
	@Lob
	private byte[] fileData;
	//default Constructor
	public Documents() {
		super();
	}
	//one parameter constructor
	public Documents(int fileId) {
		super();
		this.fileId = fileId;
	}
	//setters and getters
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	//toString() method
	@Override
	public String toString() {
		return "Documents [fileId=" + fileId + ", fileName=" + fileName
				+ ", fileData=" + Arrays.toString(fileData) + "]";
	}
	//comareTo() method
	@Override
	public int compareTo(Documents o) {
		return this.getFileId()-o.getFileId();
	}
}
