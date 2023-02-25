package com.wanderercontrols;

import java.util.List;
import java.util.Stack;

import com.dto.Post;
import com.dto.Wanderer;
import com.util.UIValidator;

public class WandererControlView implements WandererControlViewCallBack{
	
	private WandererControlControllerCallBack wandererControlController;
	
	public WandererControlView() {
		this.wandererControlController = new WandererControlController(this);
	}

	public void displayControls(Wanderer wanderer) {
		printNotifications(wanderer);
		getChoiceAndProceed(wanderer);
	}

	private void printNotifications(Wanderer wanderer) {

		Stack<String> notifications = wandererControlController.getNotifications(wanderer);
		if (!notifications.isEmpty()) {
			System.out.println("\tYou have some notifications");
		}

		while (!notifications.isEmpty()) {
			System.out.println("-> " + notifications.pop());
		}
	}

	private void getChoiceAndProceed(Wanderer wanderer) {
		System.out.println("Enter 1 to wander ");
		System.out.println("Enter 2 to post your thoughts");
		System.out.println("Enter 3 to follow peoples in wander");
		System.out.println("Enter 4 to see follow requests ");
		System.out.println("Enter 5 to see your personalized feed");
		System.out.println("Enter 6 to see your profile");
		System.out.println("Enter 0 to exit");
		int choice = UIValidator.getChoice();

		switch (choice) {
		case 1:
			wander(wanderer);
			break;
		case 2:
			post(wanderer);
			break;
		case 3:
			follow(wanderer);
			break;
		case 4:
			requests(wanderer);
			break;
		case 5:
			personalisedFeed(wanderer);
			break;
		case 6:
			viewProfile(wanderer);
			break;
		case 0:
			return;
		default:
			return;
		}

	}

	private void personalisedFeed(Wanderer wanderer) {
		System.out.println("\tYour personalized feed\n");
		List<Post> posts = wandererControlController.getPersonalisedPost(wanderer);
		for (Post post : posts) {
			System.out.println(post.toString());
			System.out.println("Enter 1 to thumbsUp for the post");
			System.out.println("Enter 2 to thumbsDown for the post");
			System.out.println("Enter 3 to report post");
			System.out.println("Enter 4 to skip");
			byte choice = UIValidator.getChoice();
			if (choice == 1) {
				String result = wandererControlController.thumbsUp(post, wanderer);
				System.out.println(result);
			} else if (choice == 2) {
				String result = wandererControlController.thumbsDown(post, wanderer);
				System.out.println(result);
			}
		}
		getChoiceAndProceed(wanderer);

	}

	private void viewProfile(Wanderer wanderer) {
		System.out.println(wanderer.toString());
		getChoiceAndProceed(wanderer);
	}

	private void requests(Wanderer wanderer1) {
		List<Wanderer> wanderers = wandererControlController.getRequests(wanderer1);
		System.out.println(wanderers.size() + " wanderers requested you to follow\n");
		for (int i = 0; i < wanderers.size(); i++) {
			Wanderer wanderer2 = wanderers.get(i);
			System.out.println(wanderer2.toString());
			System.out.println("Enter 1 to accept request");
			System.out.println("Enter 2 to accept request and followBack");
			System.out.println("Enter 3 to skip\n");
			int choice = UIValidator.getIntChoice();
			if (choice == 1) {
				String result = wandererControlController.acceptRequest(wanderer1, wanderer2);
				System.out.println(result);
			} else if (choice == 2) {
				String result = wandererControlController.acceptRequestAndFollow(wanderer1, wanderer2);
				System.out.println(result);
			}
		}
		getChoiceAndProceed(wanderer1);

	}

	private void follow(Wanderer wanderer1) {
		List<Wanderer> wanderers = wandererControlController.getWanderers();
		for (Wanderer wanderer2 : wanderers) {
			if (wanderer1.equals(wanderer2)) {
				continue;
			}
			System.out.println(wanderer2.toString());
			System.out.println("Enter 1 to send follow request : ");
			System.out.println("Enter 2 to skip : \n");
			int choice = UIValidator.getIntChoice();
			if (choice == 1) {
				String result = wandererControlController.sendRequest(wanderer1, wanderer2);
				System.out.println(result);
			}
		}
		getChoiceAndProceed(wanderer1);
	}

	private void post(Wanderer wanderer) {
		System.out.println("\tWrite your thoughts down");
		String postString = UIValidator.getPostString();
		String result = wandererControlController.post(wanderer, postString);
		System.out.println(result);
		getChoiceAndProceed(wanderer);
	}

	private void wander(Wanderer wanderer) {
		List<Post> randomPosts = wandererControlController.getRandomPost(wanderer);
		System.out.println("\tHere are some random posts around the world!\n");
		for (Post post : randomPosts) {
			System.out.println(post.toString());
			System.out.println("Enter 1 to thumbsUp for the post");
			System.out.println("Enter 2 to thumbsDown for the post");
			System.out.println("Enter 3 to skip");
			byte choice = UIValidator.getChoice();
			if (choice == 1) {
				String result = wandererControlController.thumbsUp(post, wanderer);
				System.out.println(result);
			} else if (choice == 2) {
				String result = wandererControlController.thumbsDown(post, wanderer);
				System.out.println(result);
			}
		}
		getChoiceAndProceed(wanderer);
	}
}
