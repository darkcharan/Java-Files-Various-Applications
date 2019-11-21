package com.ProductBean;

import java.io.Serializable;

public class ProductBean implements Serializable{
	private int pno;
	private String pname;
	private int pquantity;
	private double pweight;
	private double pprice;
	public ProductBean(int pno, String pname, int pquantity, double pweight, double pprice) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pquantity = pquantity;
		this.pweight = pweight;
		this.pprice = pprice;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public double getPweight() {
		return pweight;
	}
	public void setPweight(double pweight) {
		this.pweight = pweight;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	@Override
	public String toString() {
		return "" + pno + "\t" + pname + "\t" + pquantity + "\t" + pweight
				+ "\t" + pprice + "";
	}
	
	
	
	

}
