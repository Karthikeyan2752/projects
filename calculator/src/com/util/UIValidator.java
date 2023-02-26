package com.util;

import java.time.LocalDate;
import java.util.Scanner;

public class UIValidator {

	private static Scanner scanner = new Scanner(System.in);

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

	public static LocalDate getDateFromUser() {
		String dateString = scanner.next();
		LocalDate date = null;
		try {
			date = LocalDate.parse(dateString);
			return date;
		} catch (Exception e) {
			System.out.println("Please enter correct date : ");
			return getDateFromUser();
		}
	}

}
