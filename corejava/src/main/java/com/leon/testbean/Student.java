package com.leon.testbean;

public class Student extends People{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String snum;
	private Classa classa;
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public Classa getClassa() {
		return classa;
	}
	public void setClassa(Classa classa) {
		this.classa = classa;
	}
	
}
