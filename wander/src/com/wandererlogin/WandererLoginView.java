package com.wandererlogin;

import java.util.Scanner;

public class WandererLoginView implements WandererLoginViewCallBack {
	private WandererLoginControllerCallBack wandererLoginController;
	private Scanner scanner = new Scanner(System.in);

	public WandererLoginView() {
		this.wandererLoginController = new WandererLoginController(this);
	}


}
