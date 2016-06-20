package com.mac.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {

	@Id
	private PlayerKey key;

	private String team;
	private String sports;

	public Player() {
	}

	public Player(PlayerKey key, String team, String sports) {
		this.key = key;
		this.team = team;
		this.sports = sports;
	}
	public PlayerKey getKey() {
		return key;
	}
	public void setKey(PlayerKey key) {
		this.key = key;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}

}
