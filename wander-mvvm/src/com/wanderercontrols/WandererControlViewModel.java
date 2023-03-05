package com.wanderercontrols;

import java.util.List;
import java.util.Stack;

import com.model.Post;
import com.model.Wanderer;
import com.repository.DBRepository;

public class WandererControlViewModel {

	private WandererControlView wandererControlView;

	public WandererControlViewModel(WandererControlView wandererControlView) {
		this.wandererControlView = wandererControlView;
	}


	public List<Wanderer> getWanderers() {
		return DBRepository.getInstance().getWanderers();
	}


	public String sendRequest(Wanderer wanderer1, Wanderer wanderer2) {
		return DBRepository.getInstance().sendRequest(wanderer1, wanderer2);
	}


	public List<Wanderer> getRequests(Wanderer wanderer1) {
		return DBRepository.getInstance().getRequests(wanderer1);
	}


	public String acceptRequest(Wanderer wanderer1, Wanderer wanderer2) {
		return DBRepository.getInstance().acceptRequest(wanderer1, wanderer2);
	}


	public String acceptRequestAndFollow(Wanderer wanderer1, Wanderer wanderer2) {
		return DBRepository.getInstance().acceptRequestAndFollow(wanderer1, wanderer2);
	}


	public String post(Wanderer wanderer, String postString) {
		return DBRepository.getInstance().post(wanderer, postString);
	}


	public String thumbsUp(Post post, Wanderer wanderer) {
		return DBRepository.getInstance().thumbsUp(wanderer,post);
	}
	

	public String thumbsDown(Post post, Wanderer wanderer) {
		return DBRepository.getInstance().thumbsDown(wanderer,post);
	}


	public List<Post> getPersonalisedPost(Wanderer wanderer) {
		return DBRepository.getInstance().getPersonalisedPost(wanderer);
	}


	public List<Post> getRandomPost(Wanderer wanderer) {
		return DBRepository.getInstance().getRandomPost(wanderer);
	}


	public Stack<String> getNotifications(Wanderer wanderer) {
		return DBRepository.getInstance().getNotifications(wanderer);
	}


	public List<Wanderer> getFollowers(Wanderer wanderer) {
		return DBRepository.getInstance().getFollowers(wanderer);
	}


	public List<Wanderer> getFollowings(Wanderer wanderer) {
		return DBRepository.getInstance().getFollowings(wanderer);
	}


	public List<Post> getPost(Wanderer wanderer) {
		return DBRepository.getInstance().getPost(wanderer);
	}

}
