package com.mac.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Student {

	@Id
	@SequenceGenerator(sequenceName = "studentidseq", name = "studentid", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentid")
	private int id;
	private String name;

	@Embedded
	private StudentDetails details;

	public Student() {
	}

	public Student(String name, StudentDetails details) {
		this.name = name;
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentDetails getDetails() {
		return details;
	}

	public void setDetails(StudentDetails details) {
		this.details = details;
	}

}
