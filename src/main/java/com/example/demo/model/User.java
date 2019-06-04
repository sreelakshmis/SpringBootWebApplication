package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue
	private int userId;

	private String firstName;

	private String LastName;

	@OneToMany(mappedBy = "user")
	private List<Post> post;

	public User() {
	}

	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		LastName = lastName;
	}

	public User(int userId, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		LastName = lastName;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return LastName;
	}

}
