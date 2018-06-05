package com.leon.bean;
// Generated 2018-5-18 13:50:29 by Hibernate Tools 3.4.0.CR1

/**
 * Userinfo generated by hbm2java
 */
public class Userinfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userid;
	private String username;
	private String passwd;
	private String telephone;
	private String remark;
	private String address;

	public Userinfo() {
	}

	public Userinfo(String userid, String username, String passwd) {
		this.userid = userid;
		this.username = username;
		this.passwd = passwd;
	}

	public Userinfo(String userid, String username, String passwd, String telephone, String remark, String address) {
		this.userid = userid;
		this.username = username;
		this.passwd = passwd;
		this.telephone = telephone;
		this.remark = remark;
		this.address = address;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}