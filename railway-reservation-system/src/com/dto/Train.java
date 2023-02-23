package com.dto;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Train {

	private String name;
	private int ticketPrice;
	private Queue<Ticket> waitingList = new LinkedList<>();
	private Queue<Ticket> rACList = new LinkedList<>();
	private Date onBoardingDate;
	private int availableRAC = 1;
	private int availableLowerBerth = 1;
	private int availableUpperBerth = 1;
	private int availableMiddleBerth = 1;
	private int availableWaitingList = 1;
	private RailwayStation from;
	private RailwayStation to;

	public Queue<Ticket> getWaitingListQueue() {
		return waitingList;
	}

	public Queue<Ticket> getRACListQueue() {
		return rACList;
	}

	public Train(String name, RailwayStation from, RailwayStation to, Date onBoardingDate) {
		this.name = name;
		this.to = to;
		this.onBoardingDate = onBoardingDate;
		this.from = from;
	}

	public Date getOnBoardingDate() {
		return onBoardingDate;
	}

	public void setOnBoardingDate(Date onBoardingDate) {
		this.onBoardingDate = onBoardingDate;
	}

	public int getAvailableRAC() {
		return availableRAC;
	}

	public void setAvailableRAC(int availableRAC) {
		this.availableRAC = availableRAC;
	}

	public int getAvailableLowerBerth() {
		return availableLowerBerth;
	}

	public void setAvailableLowerBerth(int availableLowerBerth) {
		this.availableLowerBerth = availableLowerBerth;
	}

	public int getAvailableUpperBerth() {
		return availableUpperBerth;
	}

	public void setAvailableUpperBerth(int availableUpperBerth) {
		this.availableUpperBerth = availableUpperBerth;
	}

	public int getAvailableMiddleBerth() {
		return availableMiddleBerth;
	}

	public void setAvailableMiddleBerth(int availableMiddleBerth) {
		this.availableMiddleBerth = availableMiddleBerth;
	}

	public int getWaitingList() {
		return availableWaitingList;
	}

	public void setWaitingList(int waitingList) {
		this.availableWaitingList = waitingList;
	}

	public RailwayStation getFrom() {
		return from;
	}

	public void setFrom(RailwayStation from) {
		this.from = from;
	}

	public RailwayStation getTo() {
		return to;
	}

	public void setTo(RailwayStation to) {
		this.to = to;
	}



}
