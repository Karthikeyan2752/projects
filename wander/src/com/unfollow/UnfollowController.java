package com.unfollow;

import com.unfollow.UnfollowModel.UnfollowModelControllerCallBack;

public class UnfollowController
		implements UnfollowControllerCallBack, UnfollowModelControllerCallBack {

	private UnfollowViewCallBack unFollowView;
	private UnfollowModelCallBack unFollowModel;

	public UnfollowController(UnfollowView unFollowView) {
		this.unFollowView = unFollowView;
		this.unFollowModel = new UnfollowModel(this);
	}

}
