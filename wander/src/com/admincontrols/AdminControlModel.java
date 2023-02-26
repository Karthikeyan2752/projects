package com.admincontrols;

import java.util.List;

import com.dto.Post;
import com.dto.Report;
import com.dto.Wanderer;
import com.repository.DBRepository;

public class AdminControlModel implements AdminControlModelCallBack {

	private AdminControlControllerCallBack adminControlController;

	public AdminControlModel(AdminControlController adminControlController) {
		this.adminControlController = adminControlController;
	}

	public interface AdminControlModelControllerCallBack {

	}

	@Override
	public String addReports(String reason, Post post, Wanderer wanderer) {
		return DBRepository.getInstance().addReports(reason, post, wanderer);
	}

	@Override
	public List<Report> getReports() {
		return DBRepository.getInstance().getReports();
	}

	@Override
	public String deletePost(Post post, Wanderer author) {
		return DBRepository.getInstance().deletePost(post, author);
	}

	@Override
	public String deleteAuthor(Post post, Wanderer author) {
		return DBRepository.getInstance().deleteAuthor(post, author);
	}

}
