package com.post;

import com.post.PostModel.PostModelControllerCallBack;

public class PostController implements PostControllerCallBack, PostModelControllerCallBack {

	private PostViewCallBack postView;
	private PostModelCallBack postModel;

	public PostController(PostView postView) {
		this.postView = postView;
		this.postModel = new PostModel(this);
	}

}
