package dto;

import java.util.Date;

public class UserInfo implements Comparable<UserInfo>{
	private String id;
	private String username;
	private String sex;
	private Date birthday;
	
	public UserInfo() {
		super();
	}
	
	public UserInfo(String id, String username, String sex, Date birthday) {
		super();
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int compareTo(UserInfo o) {
		long i = this.birthday.getTime()-o.birthday.getTime();
		if (i>0)
			return 1;
		else if(i==0){
			return 0;
		}
		else 
			return -1;
	}

	
	
	
}
