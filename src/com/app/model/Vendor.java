package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ven_tab")
public class Vendor implements Comparable<Vendor> {
	@Id
	@Column(name="vid",length=10)
	private int venId;
	@Column(name="vcode",length=20)
	private String venCode;
	@Column(name="vname",length=20)
	private String venName;
	@Column(name="vtype",length=20)
	private String venType;
	@Column(name="vmail",length=50)
	private String venEmail;
	@Column(name="vcnt",length=20)
	private String venContact;
	@Column(name="vadrs",length=100)
	private String venAddress;
	//default Constructor
	public Vendor() {
		super();
	}
	// 1-parameter parameterized constructor
	public Vendor(int venId) {
		super();
		this.venId = venId;
	}
	//setters and getters
	public int getVenId() {
		return venId;
	}
	public void setVenId(int venId) {
		this.venId = venId;
	}
	public String getVenCode() {
		return venCode;
	}
	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}
	public String getVenName() {
		return venName;
	}
	public void setVenName(String venName) {
		this.venName = venName;
	}
	public String getVenType() {
		return venType;
	}
	public void setVenType(String venType) {
		this.venType = venType;
	}
	public String getVenEmail() {
		return venEmail;
	}
	public void setVenEmail(String venEmail) {
		this.venEmail = venEmail;
	}
	public String getVenContact() {
		return venContact;
	}
	public void setVenContact(String venContact) {
		this.venContact = venContact;
	}
	public String getVenAddress() {
		return venAddress;
	}
	public void setVenAddress(String venAddress) {
		this.venAddress = venAddress;
	}
	//compareTo() method for sorting purpose
	@Override
	public int compareTo(Vendor o) {
		return this.getVenId()-o.getVenId();
	}
	//to string
	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venCode=" + venCode + ", venName="
				+ venName + ", vetType=" + venType + ", venEmail=" + venEmail
				+ ", venContact=" + venContact + ", venAddress=" + venAddress
				+ "]";
	}
}
