package com.mac.entity;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {

	private String make;

	public Car() {
	}

	public Car(String make) {
		this.make = make;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

}
