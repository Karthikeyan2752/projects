package com.unfollow;

import java.util.Scanner;

public class UnfollowView implements UnfollowViewCallBack {

	private UnfollowControllerCallBack unFollowController;
	private Scanner scanner = new Scanner(System.in);

	public UnfollowView() {
		this.unFollowController = new UnfollowController(this);
	}

}
