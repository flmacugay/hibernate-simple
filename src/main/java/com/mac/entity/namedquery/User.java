package com.mac.entity.namedquery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
		@NamedQuery(name = "User.byId", query = "from User where userId=?"),
		@NamedQuery(name = "User.byName", query = "from User where name=?")})
@Entity
public class User {

	@Id
	@GeneratedValue
	private int userId;
	private String name;

	public User() {
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
