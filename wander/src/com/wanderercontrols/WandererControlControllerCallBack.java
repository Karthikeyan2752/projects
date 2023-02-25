package com.wanderercontrols;

import java.util.List;
import java.util.Stack;

import com.dto.Post;
import com.dto.Wanderer;

public interface WandererControlControllerCallBack {

	List<Wanderer> getWanderers();

	String sendRequest(Wanderer wanderer1, Wanderer wanderer2);

	List<Wanderer> getRequests(Wanderer wanderer1);

	String acceptRequest(Wanderer wanderer1, Wanderer wanderer2);

	String acceptRequestAndFollow(Wanderer wanderer1, Wanderer wanderer2);

	String post(Wanderer wanderer, String postString);

	public String thumbsDown(Post post, Wanderer wanderer);

	String thumbsUp(Post post, Wanderer wanderer);

	List<Post> getRandomPost(Wanderer wanderer);

	List<Post> getPersonalisedPost(Wanderer wanderer);

	Stack<String> getNotifications(Wanderer wanderer);

}