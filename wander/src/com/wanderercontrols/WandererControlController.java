package com.wanderercontrols;

import java.util.List;
import java.util.Stack;

import com.dto.Post;
import com.dto.Wanderer;

public class WandererControlController implements WandererControlControllerCallBack {

	private WandererControlViewCallBack wandererControlView;
	private WandererControlModelCallBack wandererControlModel;

	public WandererControlController(WandererControlViewCallBack wandererControlView) {
		this.wandererControlView = wandererControlView;
		this.wandererControlModel = new WandererControlModel(this);
	}

	@Override
	public List<Wanderer> getWanderers() {
		return wandererControlModel.getWanderers();
	}

	@Override
	public String sendRequest(Wanderer wanderer1, Wanderer wanderer2) {
		return wandererControlModel.sendRequest(wanderer1, wanderer2);
	}

	@Override
	public List<Wanderer> getRequests(Wanderer wanderer1) {
		return wandererControlModel.getRequests(wanderer1);
	}

	@Override
	public String acceptRequest(Wanderer wanderer1, Wanderer wanderer2) {
		return wandererControlModel.acceptRequest(wanderer1, wanderer2);
	}

	@Override
	public String acceptRequestAndFollow(Wanderer wanderer1, Wanderer wanderer2) {
		return wandererControlModel.acceptRequestAndFollow(wanderer1, wanderer2);
	}

	@Override
	public String post(Wanderer wanderer, String postString) {
		return wandererControlModel.post(wanderer, postString);
	}

	@Override
	public String thumbsUp(Post post, Wanderer wanderer) {
		return wandererControlModel.thumbsUp(post, wanderer);
	}

	@Override
	public String thumbsDown(Post post, Wanderer wanderer) {
		return wandererControlModel.thumbsDown(post, wanderer);
	}

	@Override
	public List<Post> getRandomPost(Wanderer wanderer) {
		return wandererControlModel.getRandomPost(wanderer);
	}

	@Override
	public List<Post> getPersonalisedPost(Wanderer wanderer) {
		return wandererControlModel.getPersonalisedPost(wanderer);
	}

	@Override
	public Stack<String> getNotifications(Wanderer wanderer) {
		return wandererControlModel.getNotifications(wanderer);
	}

	@Override
	public List<Wanderer> getFollowers(Wanderer wanderer) {
		return wandererControlModel.getFollowers(wanderer);
	}

	@Override
	public List<Wanderer> getFollowings(Wanderer wanderer) {
		return wandererControlModel.getFollowings(wanderer);
	}

	@Override
	public List<Post> getPost(Wanderer wanderer) {
		return wandererControlModel.getPost(wanderer);
	}

}
