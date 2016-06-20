package com.mac.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

	@Id
	@GeneratedValue
	private int id;
	private String engine;

	public Vehicle() {
	}

	public Vehicle(String engine) {
		this.engine = engine;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

}
