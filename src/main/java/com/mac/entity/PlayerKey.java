package com.mac.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PlayerKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5516674221786520994L;

	private String name;
	private int jerseyNumber;

	public PlayerKey() {
	}

	public PlayerKey(String name, int jerseyNumber) {
		this.name = name;
		this.jerseyNumber = jerseyNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
