package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class Wanderer {

	private String name;
	private String email;
	private String mobile;
	private Date dOB;
	private String password;
	private int userId;
	private Stack<String> notifications = new Stack<>();
	private List<Wanderer> followers = new ArrayList<>();
	private List<Wanderer> followings = new ArrayList<>();
	private List<Wanderer> requests = new ArrayList<>();
	private String bio;
	private List<Post> posts = new ArrayList<>();

	public List<Wanderer> getRequests() {
		return requests;
	}

	public void addRequests(Wanderer request) {
		requests.add(request);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getdOB() {
		return dOB;
	}

	public Stack<String> getNotifications() {
		return notifications;
	}

	public int getUserId() {
		return userId;
	}

	public List<Wanderer> getFollowers() {
		return followers;
	}

	public void addFollowers(Wanderer follower) {
		followers.add(follower);
	}

	public List<Wanderer> getFollowings() {
		return followings;
	}

	public void addFollowings(Wanderer following) {
		followings.add(following);
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Wanderer(String name, String email, String mobile, Date dOB, int userId, String bio) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.dOB = dOB;
		this.userId = userId;
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "------------------" + name + "------------------\n|" + "\n|ID : " + userId + "\n|" + name + "\n|bio : "
				+ bio + "\n|no of posts : " + posts.size() + "\n|followers : " + followers.size() + "\n|following : "
				+ followings.size() + "\n|\n-------------------------------------------\n";
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}


}
