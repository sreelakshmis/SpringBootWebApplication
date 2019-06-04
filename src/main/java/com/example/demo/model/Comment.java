package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Integer id;

	private String commentString;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Post post;

	public Comment(Integer id, String commentString) {
		super();
		this.id = id;
		this.commentString = commentString;
	}

	public Comment(String commentString, Post post) {
		super();
		this.commentString = commentString;
		this.post = post;
	}

	public String getCommentString() {
		return commentString;
	}

	public void setCommentString(String commentString) {
		this.commentString = commentString;
	}

	public Comment() {
	}

	public Comment(Integer id, String commentString, Post post, User user) {
		super();
		this.id = id;
		this.post = post;
		this.commentString = commentString;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Integer getId() {
		return id;
	}

	public Post getPost() {
		return post;
	}

}
