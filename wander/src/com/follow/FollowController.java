package com.follow;

import com.follow.FollowModel.PostModelControllerCallBack;

public class FollowController implements FollowControllerCallBack, PostModelControllerCallBack {

	private FollowViewCallBack followView;
	private FollowModelCallBack followModel;

	public FollowController(FollowView followView) {
		this.followView = followView;
		this.followModel = new FollowModel(this);
	}

}
