package com.sample.bean;

public class SampleBean {
	private int sno;
	private String sname;
	private String saddress;
	private double samount;
	public SampleBean(int sno, String sname, String saddress, double samount) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.saddress = saddress;
		this.samount = samount;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public double isSamount() {
		return samount;
	}
	public void setSamount(double samount) {
		this.samount = samount;
	}
	@Override
	public String toString() {
		return "" + sno + "\t" + sname + "\t" + saddress + "\t" + samount + "";
	}
	
	
	

}
