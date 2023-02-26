package com.admincontrols;

import java.util.List;

import com.dto.Post;
import com.dto.Report;
import com.dto.Wanderer;

public interface AdminControlModelCallBack {

	String addReports(String reason, Post post, Wanderer wanderer);

	List<Report> getReports();

	String deletePost(Post post, Wanderer author);

	String deleteAuthor(Post post, Wanderer author);

}
