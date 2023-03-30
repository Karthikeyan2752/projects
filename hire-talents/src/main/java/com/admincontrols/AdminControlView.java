package com.admincontrols;

import java.util.Scanner;

public class AdminControlView {

	private AdminControlViewModel adminControlViewModel;
	private Scanner scanner = new Scanner(System.in);

	public AdminControlView() {
		this.adminControlViewModel = new AdminControlViewModel(this);
	}

	public void displayControls() {

	}


}
