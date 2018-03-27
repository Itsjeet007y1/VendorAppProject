package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cust_table")
public class Customer implements Comparable<Customer> {
	@Id
	private int custId;
	private String custCode;
	private String custName;
	private double contractTime;
	private double percent;
	private String custMode;
	private String custEmail;
	private String custType;
	private String custAddress;
	private String description;
	private String pwd;
	private String token;
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	//default constructor
	public Customer() {
		super();
	}
	//parameterized constructor
	public Customer(int custId) {
		super();
		this.custId = custId;
	}
	//setters and getters
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public double getContractTime() {
		return contractTime;
	}
	public void setContractTime(double contractTime) {
		this.contractTime = contractTime;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public String getCustMode() {
		return custMode;
	}
	public void setCustMode(String custMode) {
		this.custMode = custMode;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//compareTo() method
	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return this.getCustId()-o.getCustId();
	}
}
