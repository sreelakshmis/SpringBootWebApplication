package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	private String inputMessage;

	private Timestamp timestamp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Post() {

	}

	public Post(String inputMessage, Timestamp timestamp) {
		super();
		this.inputMessage = inputMessage;
		this.timestamp = timestamp;
	}

	public Post(Integer id) {
		super();
		this.id = id;
	}

	public Post(String inputMessage, Timestamp timestamp, User user) {
		super();
		this.inputMessage = inputMessage;
		this.timestamp = timestamp;
		this.user = user;
	}

	public Post(Integer id, String inputMessage) {
		super();
		this.id = id;
		this.inputMessage = inputMessage;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInputMessage(String inputMessage) {
		this.inputMessage = inputMessage;
	}

	public Integer getId() {
		return id;
	}

	public String getInputMessage() {
		return inputMessage;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", inputMessage=" + inputMessage + "]";
	}

}
