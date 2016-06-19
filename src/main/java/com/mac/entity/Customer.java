package com.mac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name = "CUSTOMER_DETAIL")
public class Customer {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	@Column(name = "REWARD_POINTS", table = "CUSTOMER_DETAIL")
	private int rewardPoints;

	@Column(table = "CUSTOMER_DETAIL")
	private String address;

	public Customer() {
	}
	public Customer(String name, int rewardPoints, String address) {
		this.name = name;
		this.rewardPoints = rewardPoints;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
