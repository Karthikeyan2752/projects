package com.admincontrols;

import java.util.List;

import com.dto.Post;
import com.dto.Report;
import com.dto.Wanderer;

public interface AdminControlControllerCallBack {

	String addReports(String reason, Post post, Wanderer wanderer);

	List<Report> getReports();

	String deleteAuthor(Post post, Wanderer author);

	String deletePost(Post post, Wanderer author);

}
