package com.post;

import java.util.Scanner;

public class PostView implements PostViewCallBack {

	private PostControllerCallBack postController;
	private Scanner scanner = new Scanner(System.in);

	public PostView() {
		this.postController = new PostController(this);
	}

}
