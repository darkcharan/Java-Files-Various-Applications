package com.School.baen;

import java.io.Serializable;

public class SchoolBean implements Serializable {
	private int sno;
	private String Sname;
	private String saddr;
	private double sfees;
	
	public SchoolBean(int sno, String sname, String saddr, double sfees) {
		super();
		this.sno = sno;
		Sname = sname;
		this.saddr = saddr;
		this.sfees = sfees;
	}
	
	

	public int getSno() {
		return sno;
	}



	public void setSno(int sno) {
		this.sno = sno;
	}



	public String getSname() {
		return Sname;
	}



	public void setSname(String sname) {
		Sname = sname;
	}



	public String getSaddr() {
		return saddr;
	}



	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}



	public double getSfees() {
		return sfees;
	}



	public void setSfees(double sfees) {
		this.sfees = sfees;
	}



	@Override
	public String toString() {
		return "" + sno + "\t" + Sname + "\t" + saddr + "\t" + sfees + "";
	}
	
	

}
