package com.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import com.dto.Admin;
import com.dto.Credentials;
import com.dto.Post;
import com.dto.Wanderer;

public class DBRepository {

	private static DBRepository dBRInstance;
	private static int userId;
	private List<Credentials> adminCredentials = new ArrayList<Credentials>();
	private List<Wanderer> wanderers = new ArrayList<>();
	private List<Post> posts = new ArrayList<>();
	private Admin admin = null;

	private DBRepository() {

	}

	public static DBRepository getInstance() {
		if (dBRInstance == null) {
			dBRInstance = new DBRepository();
			dBRInstance.initialSetup();
		}
		return dBRInstance;
	}

	public Admin checkValidUser(String userName, String password) {
		for (Credentials credential : adminCredentials) {
			if (credential.getUserName().equals(userName) && credential.getPassword().equals(password)) {
				return credential;
			}
		}
		return null;
	}

	private void initialSetup() {
		adminCredentials.add(new Credentials("1", "admin", "123"));
		Wanderer k = new Wanderer("karthi", "k@gmail.com", "1234567890", new Date(), 1, "bio");
		Wanderer kk = new Wanderer("kk", "k@gmail.com", "1234567890", new Date(), 3, "bio3");
		k.setPassword("123");
		kk.setPassword("123");
		Wanderer t = new Wanderer("tom", "t@gmail.com", "1234567890", new Date(), 2, "bio2");
		Post post = new Post("sasas", new Date(), t);
		posts.add(post);
		t.setPassword("123");
		wanderers.add(k);
		wanderers.add(kk);
		wanderers.add(t);

	}

	public Wanderer login(int userId, String password) {
		for (Wanderer wanderer : wanderers) {
			if (wanderer.getUserId() == userId && wanderer.getPassword().equals(password)) {
				return wanderer;
			}
		}
		return null;
	}

	public Wanderer signUp(String name, String email, String mobile, String bio, Date dOB, String password) {
		Wanderer wanderer = new Wanderer(name, email, mobile, dOB, userId++, bio);
		wanderers.add(wanderer);
		return wanderer;
	}

	public List<Wanderer> getWanderers() {
		return wanderers;
	}

	public String sendRequest(Wanderer wanderer1, Wanderer wanderer2) {
		if (wanderer2.getFollowers().contains(wanderer1)) {
			return "you are already a follower of " + wanderer1.getName();
		}
		wanderer2.addRequests(wanderer1);
		wanderer2.getNotifications().push(wanderer1.getName() + " requested you to follow");

		return "requested successfully\n";
	}

	public List<Wanderer> getRequests(Wanderer wanderer1) {
		return wanderer1.getRequests();
	}

	public String acceptRequest(Wanderer wanderer1, Wanderer wanderer2) {
		wanderer1.addFollowers(wanderer2);
		wanderer2.addFollowings(wanderer1);
		wanderer2.getNotifications().push(wanderer1.getName() + " accepted your follow request \n");
		wanderer1.getRequests().remove(wanderer2);

		return "request accepted successfully\n";
	}

	public String acceptRequestAndFollow(Wanderer wanderer1, Wanderer wanderer2) {

		wanderer1.addFollowers(wanderer2);
		wanderer1.addFollowings(wanderer2);
		wanderer2.getNotifications()
				.push(wanderer1.getName() + " accepted your follow request and\nstarted following you!\n");
		wanderer2.addFollowings(wanderer1);
		wanderer2.addFollowers(wanderer1);

		wanderer1.getRequests().remove(wanderer2);

		return "request accepted successfully and you are now following " + wanderer2.getName() + "\n";
	}

	public String post(Wanderer wanderer, String postString) {
		Post post = new Post(postString, new Date(), wanderer);
		wanderer.getPosts().add(post);
		posts.add(post);
		for (Wanderer wanderer2 : wanderer.getFollowers()) {
			wanderer2.getNotifications().push(wanderer.getName() + " has posted a new post\n");
		}
		for (Wanderer wanderer2 : wanderer.getFollowings()) {
			wanderer2.getNotifications().push(wanderer.getName() + " has posted a new post\n");
		}
		return "post posted successfully!\n";
	}

	public String thumbsUp(Wanderer wanderer, Post post) {
		if (post.getThumbsUps().contains(wanderer)) {
			return "you have already thumbsUpped it!";
		}
		post.getThumbsUps().add(wanderer);
		var author = post.getUser();
		author.getNotifications().push(author.getName() + " has given a thumbsUp for your post");

		return "ThumbsUpped successfully";
	}

	public String thumbsDown(Wanderer wanderer, Post post) {
		if (post.getThumbsDowns().contains(wanderer)) {
			return "you have already thumbsDowned it!\n";
		}
		post.getThumbsDowns().add(wanderer);
		var author = post.getUser();
		author.getNotifications().push(author.getName() + " has given a thumbsDown for your post\n");

		return "ThumbsDowned successfully\n";
	}

	public List<Post> getRandomPost(Wanderer wanderer) {
		if (posts.size() < 5) {
			return posts;
		}
		List<Post> randomPosts = new ArrayList<>();
		Random r = new Random();
		int maxSize = 4;
		if (posts.size() < 5) {
			maxSize = posts.size() - 1;
		}
		Set<Integer> set = new HashSet<>();
		int index = maxSize;
		while (index > 0) {
			int i = r.nextInt(maxSize) + 0;
			if (set.add(i)) {
				randomPosts.add(posts.get(i));
			}
			index--;
		}

		return randomPosts;
	}

	public List<Post> getPersonalisedPost(Wanderer wanderer) {
		List<Post> posts = new ArrayList<>();
		for (Wanderer followers : wanderer.getFollowers()) {
			posts.addAll(followers.getPosts());
		}
		for (Wanderer followee : wanderer.getFollowings()) {
			posts.addAll(followee.getPosts());
		}
		return posts;
	}

	public Stack<String> getNotifications(Wanderer wanderer) {
		return wanderer.getNotifications();
	}

}

