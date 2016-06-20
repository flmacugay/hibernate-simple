package com.mac.entity;

import javax.persistence.Embeddable;

@Embeddable
public class StudentDetails {

	private int year;
	private String course;
	private String college;
	private String email;

	public StudentDetails() {
	}

	public StudentDetails(int year, String course, String college,
			String email) {
		this.year = year;
		this.course = course;
		this.college = college;
		this.email = email;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
