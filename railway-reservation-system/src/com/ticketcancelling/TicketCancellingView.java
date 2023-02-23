package com.ticketcancelling;

import java.util.Scanner;

public class TicketCancellingView implements TicketCancellingViewCallBack{

	private TicketCancellingControllerCallBack ticketCancellingController;
	private Scanner scanner = new Scanner(System.in);

	public TicketCancellingView() {
		this.ticketCancellingController = new TicketCancellingController(this);
	}

	public void cancelTicket() {
		System.out.println("Enter your ticket ID : ");
		int ticketID = scanner.nextInt();
		String result = ticketCancellingController.cancelTicket(ticketID);
	}
}
