package com.payment;

import java.util.Date;
import java.util.Scanner;

public class PaymentView implements PaymentViewCallBack {
	
	private PaymentControllerCallBack paymentController;
	private Scanner scanner = new Scanner(System.in);

	public PaymentView() {
		this.paymentController = new PaymentController(this);
	}

	public int payment(String depature, String arrival, Date date, int numberOfTickets, boolean tatkal) {

		int amount = paymentController.payment(depature, arrival, date, numberOfTickets, tatkal);
		if (amount == -1) {
			System.out.println("Tickets not available");
			return amount;
		}
		System.out.println("\tWelcome to IRCTC payment interface\n");
		System.out.println("Pay " + amount + " to continue booking");
		System.out.println("Type " + amount + " and press enter to pay");
		int paidAmount = scanner.nextInt();
		if (paidAmount == amount) {
			System.out.println("Payment successfull\n");
		} else {
			System.out.println("Payment failed\n");
			System.out.println("Please enter 1 to continue");
			System.out.println("Please enter 0 to exit");
			int choice = scanner.nextInt();
			if (choice == 1) {
				payment(depature, arrival, date, numberOfTickets, tatkal);
			} else {
				System.exit(0);
			}
		}
		return 0;
	}
	
}
