package com.EmployeeBean;

import java.io.Serializable;

public class EmployeeBean implements Serializable{
	int eno;
	String ename;
	String eaddr;
	double esalr;
	public EmployeeBean(int eno, String ename, String eaddr, double esalr) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.eaddr = eaddr;
		this.esalr = esalr;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	public double getEsalr() {
		return esalr;
	}
	public void setEsalr(double esalr) {
		this.esalr = esalr;
	}
	@Override
	public String toString() {
		return "" + eno + "\t" + ename + "\t" + eaddr + "\t" + esalr + "";
	}
	
	

}
