package com.post;

public class PostModel implements PostModelCallBack {

	private PostModelControllerCallBack postController;

	public PostModel(PostController postController) {
		this.postController = postController;
	}

	public interface PostModelControllerCallBack {

	}

}
