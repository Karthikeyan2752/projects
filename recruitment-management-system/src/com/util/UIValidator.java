package com.util;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UIValidator {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String EMAIL_PATTERN = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
	private static final String MOBILE_PATTERN = "^[0-9]{10}$";
	private static final String NAME_PATTERN = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";

	public static String getEmail() {
		String input;
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher;
		do {
			System.out.println("Enter your email:");
			input = scanner.nextLine();
			matcher = pattern.matcher(input);
		} while (!matcher.matches());
		return input;
	}

	public static String getMobileNumber() {
		String input;
		Pattern pattern = Pattern.compile(MOBILE_PATTERN);
		Matcher matcher;
		do {
			System.out.println("Enter your mobile number (10 digits):");
			input = scanner.nextLine();
			matcher = pattern.matcher(input);
		} while (!matcher.matches());
		return input;
	}

	public static String getName() {
		String input;
		Pattern pattern = Pattern.compile(NAME_PATTERN);
		Matcher matcher;
		do {
			System.out.println("Please enter your name:");
			input = scanner.nextLine();
			matcher = pattern.matcher(input);
		} while (!matcher.matches());
		return input;
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

	public static void main(String[] args) {
		getChoice();
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

	public static Date getDateFromUser() {
		System.out.println("Please enter date : (mm/dd/yyy)");
		String dateString = scanner.next();
		Date cdate = new Date();
		Date date = null;
		try {
			date = new Date(dateString);
			if (date.before(cdate)) {
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
}
