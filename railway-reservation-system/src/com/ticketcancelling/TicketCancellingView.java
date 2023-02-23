package com.ticketcancelling;

import java.util.Scanner;

public class TicketCancellingView implements TicketCancellingViewCallBack{

	private TicketCancellingControllerCallBack ticketCancellingController;
	private Scanner scanner = new Scanner(System.in);

	public TicketCancellingView() {
		this.ticketCancellingController = new TicketCancellingController(this);
	}
}
