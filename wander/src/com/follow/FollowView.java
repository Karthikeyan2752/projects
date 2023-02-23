package com.follow;

import java.util.Scanner;

public class FollowView implements FollowViewCallBack {

	private FollowControllerCallBack followController;
	private Scanner scanner = new Scanner(System.in);

	public FollowView() {
		this.followController = new FollowController(this);
	}

}
