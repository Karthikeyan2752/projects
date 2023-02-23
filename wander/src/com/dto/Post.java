package com.dto;

import java.util.List;

public class Post {

	private String post;
	private int thumbsUps;
	private int thumbsDowns;
	private List<String> comments;
	private Wanderer wanderer;

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getThumbsUps() {
		return thumbsUps;
	}

	public void setThumbsUps(int thumbsUps) {
		this.thumbsUps = thumbsUps;
	}

	public int getThumbsDowns() {
		return thumbsDowns;
	}

	public void setThumbsDowns(int thumbsDowns) {
		this.thumbsDowns = thumbsDowns;
	}

	public List<String> getComment() {
		return comments;
	}

	public void addComment(String comment) {
		comments.add(comment);
	}

	public Wanderer getUser() {
		return wanderer;
	}

	public Post(Wanderer wanderer) {
		this.wanderer = wanderer;
	}

}
