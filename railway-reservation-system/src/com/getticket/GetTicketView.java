package com.getticket;

import java.util.Scanner;

import com.dto.Ticket;

public class GetTicketView implements GetTicketViewCallBack {

	private Scanner scanner = new Scanner(System.in);
	private GetTicketControllerCallBack getTicketController;

	public GetTicketView() {
		this.getTicketController=new GetTicketController(this);
	}

	public void start() {
		getTicket();
	}

	private void getTicket() {
		System.out.println("Please enter your passenger ID : ");
		int passengerID = scanner.nextInt();
		Ticket ticket = getTicketController.getTicket(passengerID);
		if (ticket != null) {
			System.out.println(ticket.toString());
		} else {
			System.out.println("Ticket not found!");
		}

	}

}
