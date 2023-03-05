package com.model;

public class Report {

	public Post getPost() {
		return post;
	}

	public String getReason() {
		return reason;
	}

	public Wanderer getWanderer() {
		return wanderer;
	}

	private Post post;
	private String reason;
	private Wanderer wanderer;

	public Report(String reason, Post post, Wanderer wanderer) {
		super();
		this.reason = reason;
		this.post = post;
		this.wanderer = wanderer;
	}
}
