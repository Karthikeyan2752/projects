package com.payment;

import java.util.Scanner;

public class PaymentView implements PaymentViewCallBack {
	
	private PaymentControllerCallBack paymentController;
	private Scanner scanner = new Scanner(System.in);

	public PaymentView() {
		this.paymentController = new PaymentController(this);
	}
	
}
