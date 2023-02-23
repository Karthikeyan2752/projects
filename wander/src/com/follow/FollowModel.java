package com.follow;

public class FollowModel implements FollowModelCallBack {

	private PostModelControllerCallBack followController;

	public FollowModel(FollowController followController) {
		this.followController = followController;
	}

	public interface PostModelControllerCallBack {

	}

}
