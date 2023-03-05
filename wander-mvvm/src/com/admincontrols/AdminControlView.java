package com.admincontrols;

import java.util.List;
import java.util.Scanner;

import com.model.Post;
import com.model.Report;
import com.model.Wanderer;
import com.util.UIValidator;

public class AdminControlView {

	private AdminControlViewModel adminControlViewModel;
	private Scanner scanner = new Scanner(System.in);

	public AdminControlView() {
		this.adminControlViewModel = new AdminControlViewModel(this);
	}

	public void displayControls() {
		System.out.println("\tAdmin actions page\n");
		reviewReports();
	}

	public String report(String reason, Post post, Wanderer wanderer) {
		return adminControlViewModel.addReports(reason, post, wanderer);
	}

	private void reviewReports() {
		List<Report> reports = adminControlViewModel.getReports();
		for (Report report : reports) {
			Post post = report.getPost();
			Wanderer author = report.getWanderer();
			System.out.println(author.getName() + " has reported this post\n");
			System.out.println(post.toString() + " for(reason) : \n" + report.getReason());
			System.out.println("Enter 1 to delete this post");
			System.out.println("Enter 2 to delete this post and delete wanderer");
			System.out.println("Enter 3 to skip ");
			byte choice = UIValidator.getChoice();
			switch (choice) {
			case 1:
				deletePost(post, author);
				break;
			case 2:
				deleteAuthor(post, author);
				break;
			case 3:
				return;
			default:
				return;
			}
		}

	}

	private void deleteAuthor(Post post, Wanderer author) {
		String result = adminControlViewModel.deleteAuthor(post, author);
		System.out.println(result);
	}

	private void deletePost(Post post, Wanderer author) {
		String result = adminControlViewModel.deletePost(post, author);
		System.out.println(result);

	}

}
