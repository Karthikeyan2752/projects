package com.ticket.cancelling;

import java.util.Scanner;

public class TicketCancellingView implements TicketCancellingViewCallBack {
	private TicketCancellingController ticketCancellingController;
	private Scanner sc = new Scanner(System.in);

	public TicketCancellingView() {
		ticketCancellingController = new TicketCancellingController(this);
	}

	@Override
	public void getTicketId() {
		System.out.println("Are you sure, you want to cancel your ticket!");
		System.out.println(" Please enter your ticket ID: ");
		int ticketId = sc.nextInt();
		boolean status = cancelTicket(ticketId);
		if (status) {
			System.out.println("ticket cancelled succesfully!");
		} else {
			System.out.println("ticket not found!");
		}
	}

	@Override
	public boolean cancelTicket(int ticketId) {
		return ticketCancellingController.cancelTicket(ticketId);

	}

}
