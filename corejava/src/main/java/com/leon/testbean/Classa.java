package com.leon.testbean;

import java.util.List;

public class Classa {
	private String cnum;
	private Teacher cleader;
	private List<Student> students;
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	public Teacher getCleader() {
		return cleader;
	}
	public void setCleader(Teacher cleader) {
		this.cleader = cleader;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
