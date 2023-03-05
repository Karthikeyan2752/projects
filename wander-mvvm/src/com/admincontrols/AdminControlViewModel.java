package com.admincontrols;

import java.util.List;

import com.model.Post;
import com.model.Report;
import com.model.Wanderer;
import com.repository.DBRepository;

public class AdminControlViewModel {

	private AdminControlView adminControlView;

	public AdminControlViewModel(AdminControlView adminControlView) {
		this.adminControlView = adminControlView;
	}

	public String addReports(String reason, Post post, Wanderer wanderer) {
		return DBRepository.getInstance().addReports(reason, post, wanderer);
	}

	public List<Report> getReports() {
		return DBRepository.getInstance().getReports();
	}

	public String deletePost(Post post, Wanderer author) {
		return DBRepository.getInstance().deletePost(post, author);
	}

	public String deleteAuthor(Post post, Wanderer author) {
		return DBRepository.getInstance().deleteAuthor(post, author);
	}

}
