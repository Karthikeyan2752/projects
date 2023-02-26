package com.wanderercontrols;

import java.util.List;
import java.util.Stack;

import com.dto.Post;
import com.dto.Wanderer;
import com.repository.DBRepository;

public class WandererControlModel implements WandererControlModelCallBack {

	private WandererControlControllerCallBack wandererControlController;

	public WandererControlModel(WandererControlControllerCallBack wandererControlController) {
		this.wandererControlController = wandererControlController;
	}

	@Override
	public List<Wanderer> getWanderers() {
		return DBRepository.getInstance().getWanderers();
	}

	@Override
	public String sendRequest(Wanderer wanderer1, Wanderer wanderer2) {
		return DBRepository.getInstance().sendRequest(wanderer1, wanderer2);
	}

	@Override
	public List<Wanderer> getRequests(Wanderer wanderer1) {
		return DBRepository.getInstance().getRequests(wanderer1);
	}

	@Override
	public String acceptRequest(Wanderer wanderer1, Wanderer wanderer2) {
		return DBRepository.getInstance().acceptRequest(wanderer1, wanderer2);
	}

	@Override
	public String acceptRequestAndFollow(Wanderer wanderer1, Wanderer wanderer2) {
		return DBRepository.getInstance().acceptRequestAndFollow(wanderer1, wanderer2);
	}

	@Override
	public String post(Wanderer wanderer, String postString) {
		return DBRepository.getInstance().post(wanderer, postString);
	}

	@Override
	public String thumbsUp(Post post, Wanderer wanderer) {
		return DBRepository.getInstance().thumbsUp(wanderer,post);
	}
	
	@Override
	public String thumbsDown(Post post, Wanderer wanderer) {
		return DBRepository.getInstance().thumbsDown(wanderer,post);
	}

	@Override
	public List<Post> getPersonalisedPost(Wanderer wanderer) {
		return DBRepository.getInstance().getPersonalisedPost(wanderer);
	}

	@Override
	public List<Post> getRandomPost(Wanderer wanderer) {
		return DBRepository.getInstance().getRandomPost(wanderer);
	}

	@Override
	public Stack<String> getNotifications(Wanderer wanderer) {
		return DBRepository.getInstance().getNotifications(wanderer);
	}

	@Override
	public List<Wanderer> getFollowers(Wanderer wanderer) {
		return DBRepository.getInstance().getFollowers(wanderer);
	}

	@Override
	public List<Wanderer> getFollowings(Wanderer wanderer) {
		return DBRepository.getInstance().getFollowings(wanderer);
	}

	@Override
	public List<Post> getPost(Wanderer wanderer) {
		return DBRepository.getInstance().getPost(wanderer);
	}

}
