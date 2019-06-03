package com.example.demo.model;

public class Post {
	private Integer id;
	private String inputMessage;

	public Post() {

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

	@Override
	public String toString() {
		return "Post [id=" + id + ", inputMessage=" + inputMessage + "]";
	}

}
