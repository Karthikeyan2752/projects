package com.unfollow;

public class UnfollowModel implements UnfollowModelCallBack {

	private UnfollowModelControllerCallBack unFollowController;

	public UnfollowModel(UnfollowController unFollowController) {
		this.unFollowController = unFollowController;
	}

	public interface UnfollowModelControllerCallBack {

	}

}
