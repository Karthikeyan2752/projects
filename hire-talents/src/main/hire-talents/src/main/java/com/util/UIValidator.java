package com.util;

import java.time.LocalDate;
import java.util.Scanner;

public class UIValidator {

	private static Scanner scanner = new Scanner(System.in);
	public static String getEmail() {
		System.out.println("Enter your email id : \n");
		String email = scanner.next();
		return email;
	}

	public static String getMobileNumber() {
		System.out.println("Enter your mobile number : \n");
		String mobile = scanner.next();
		if (mobile.length() != 10 && !isContainsOtherChar(mobile)) {
			return getMobileNumber();
		}
		return mobile;
	}

	private static boolean isContainsOtherChar(String mobile) {
		for (char c : mobile.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	public static String getName() {
		System.out.println("Enter your name : \n");
		String name = scanner.next();
		if (isContainsOtherChar(name)) {
			return getName();
		}
		return name;
	}

	public static byte getChoice() {
		byte input;
		do {
			while (!scanner.hasNextByte()) {
				System.out.println("Invalid input. Please enter correct choice");
				scanner.next();
			}
			input = scanner.nextByte();
		} while (input < -128 || input > 127);
		scanner.nextLine();
		return input;
	}

	public static int getIntChoice() {
		int input;
		do {
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a valid input : ");
				scanner.next();
			}
			input = scanner.nextInt();
		} while (input < 1 || input > Integer.MAX_VALUE);
		scanner.nextLine();
		return input;
	}

	public static LocalDate getDateFromUser() {
		System.out.println("Please enter date : (yyy-mm-dd)");
		String dateString = scanner.next();
		LocalDate cdate = LocalDate.now();
		LocalDate date = null;
		try {
			date = LocalDate.parse(dateString);
			if (date.isBefore(cdate)) {
				System.out.println("Please enter correct date : ");
				getDateFromUser();
			}
			return date;
		} catch (Exception e) {
			System.out.println("Please enter correct date : ");
			return getDateFromUser();
		}
	}

	public static int getIntChoiceForSelecting() {
		int input;
		do {
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a valid input : ");
				scanner.next();
			}
			input = scanner.nextInt();
		} while (input < -1 || input > Integer.MAX_VALUE);
		scanner.nextLine();
		return input;
	}

	public static int getIntChoiceForSkill() {
		int input;
		do {
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a valid input : ");
				scanner.next();
			}
			input = scanner.nextInt();
		} while (input < 0 || input > 15);
		scanner.nextLine();
		return input;
	}
}
