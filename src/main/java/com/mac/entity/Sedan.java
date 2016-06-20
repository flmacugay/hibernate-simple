package com.mac.entity;

import javax.persistence.Entity;

@Entity
public class Sedan extends Car {

	private String model;

	public Sedan() {
	}

	public Sedan(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
