package com.ticketcancelling;

import java.util.Scanner;

public class TicketCancellingView {

	private TicketCancellingViewModel ticketCancellingViewModel;
	private Scanner scanner = new Scanner(System.in);

	public TicketCancellingView() {
		this.ticketCancellingViewModel = new TicketCancellingViewModel(this);
	}

	public void cancelTicket() {
		System.out.println("Enter your ticket ID : ");
		int ticketID = scanner.nextInt();
		String result = ticketCancellingViewModel.cancelTicket(ticketID);
		System.out.println(result);
	}
}
