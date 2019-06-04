package com.example.demo.wrapper;

public class CommentWrapper {

	private String commentString;
	private Integer postId;
	private Integer userId;

	public CommentWrapper() {

	}

	public CommentWrapper(String commentString, Integer postId, Integer userId) {
		super();
		this.commentString = commentString;
		this.postId = postId;
		this.userId = userId;
	}

	public void setCommentString(String commentString) {
		this.commentString = commentString;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCommentString() {
		return commentString;
	}

	public Integer getPostId() {
		return postId;
	}

	public Integer getUserId() {
		return userId;
	}

}
