package com.leon.testbean;

import java.io.Serializable;

public class People implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String sex;
	private String id;
	public People() {
		// TODO Auto-generated constructor stub
	}
	
	public People(String name, String sex, String id) {
		super();
		this.name = name;
		this.sex = sex;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
