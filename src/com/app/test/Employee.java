package com.app.test;

import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Employee {
	private int eid;
	private String ename;
	private double esal;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getEsal() {
		return esal;
	}
	public void setEsal(double esal) {
		this.esal = esal;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal
				+ "]";
	}
}
