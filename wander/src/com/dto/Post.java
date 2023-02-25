package com.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private String post;
	private Date timeStamp;
	private List<Wanderer> thumbsUps = new ArrayList<>();
	private List<Wanderer> thumbsDowns = new ArrayList<>();
	private List<Comment> comments = new ArrayList<>();
	private Wanderer wanderer;

	public Post(String post, Date timeStamp, Wanderer wanderer) {
		super();
		this.post = post;
		this.timeStamp = timeStamp;
		this.wanderer = wanderer;
	}

	@Override
	public String toString() {
		return "--------------------------\n" + post + "\n!" + thumbsDowns.size() + " ^" + thumbsUps.size();
	}
	public List<Wanderer> getThumbsUps() {
		return thumbsUps;
	}

	public List<Wanderer> getThumbsDowns() {
		return thumbsDowns;
	}

	public List<Comment> getComment() {
		return comments;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public Wanderer getUser() {
		return wanderer;
	}

	public Post(Wanderer wanderer) {
		this.wanderer = wanderer;
	}

}
