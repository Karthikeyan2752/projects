package com.payment;

import java.util.Scanner;

import com.dataclasses.Flight;

public class PaymentView implements PaymentViewCallBack {
	private PaymentControllerCallBack paymentController;
	private Scanner sc = new Scanner(System.in);

	public PaymentView() {
		this.paymentController = new PaymentController(this);
	}
	
	@Override
	public boolean payment(Flight flight, int count) {
		System.out.println("Total amount to be paid: " + flight.getTicketPrice() * count);
		System.out.println("Enter the amount mentioned above to make payment");
		int amount = sc.nextInt();
		return paymentController.payment(flight,amount,count);
	}

	
}
