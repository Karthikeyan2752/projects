package com.getticket;

import java.util.Scanner;

import com.model.Ticket;

public class GetTicketView {

	private Scanner scanner = new Scanner(System.in);
	private GetTicketViewModel getTicketViewModel;

	public GetTicketView() {
		this.getTicketViewModel = new GetTicketViewModel(this);
	}

	public void start() {
		getTicket();
	}

	private void getTicket() {
		System.out.println("Please enter your passenger ID : ");
		int passengerID = scanner.nextInt();
		Ticket ticket = getTicketViewModel.getTicket(passengerID);
		if (ticket != null) {
			System.out.println(ticket.toString());
		} else {
			System.out.println("Ticket not found!");
		}

	}

}
