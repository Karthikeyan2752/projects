package com.model;

public class Comment {

	private String comment;
	private Wanderer wanderer;

	public Comment(String comment, Wanderer wanderer) {
		super();
		this.comment = comment;
		this.wanderer = wanderer;
	}

	@Override
	public String toString() {
		return comment + "\ncommented by : " + wanderer.toString();
	}

}
