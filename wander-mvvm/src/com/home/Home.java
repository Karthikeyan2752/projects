package com.home;

import com.adminlogin.AdminLoginView;
import com.util.UIValidator;
import com.wandererlogin.WandererLoginView;

public class Home {

	public static void main(String[] args) {
		while (true) {
			WandererLoginView wandererLoginView = new WandererLoginView();
			AdminLoginView adminLoginView = new AdminLoginView();
			System.out.println("\t   WANDER");
			System.out.println("wander where the wifi is strong\n");
			System.out.println("Enter 1 for admin login : \n");
			System.out.println("Enter 2 for wanderer login/sigUp : \n");
			System.out.println("Enter 0 to exit\n");
			byte choice = UIValidator.getChoice();
			switch (choice) {
			case 1:
				adminLoginView.start();
				break;
			case 2:
				wandererLoginView.start();
				break;
			case 0:
				System.exit(0);
			default:
				System.exit(0);
			}
		}
	}


}
