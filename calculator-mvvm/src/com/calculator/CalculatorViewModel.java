package com.calculator;

import java.time.LocalDate;
import java.time.Period;

public class CalculatorViewModel {

	private CalculatorView calculatorView;

	public CalculatorViewModel(CalculatorView calculatorView) {
		this.calculatorView = calculatorView;
	}

	public double calculate(String equation) {
		double num = 0;
		char operator = '+';
		double last = 0, sum = 0;

		for (int i = 0; i < equation.length(); i++) {
			char c = equation.charAt(i);

			if (Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			}

			if (isOperator(c) || i == equation.length() - 1) {
				if (operator == '+') {
					sum += last;
					last = num;
				} else if (operator == '-') {
					sum += last;
					last = -num;
				} else if (operator == '*') {
					last *= num;
				} else if (operator == '/') {
					last /= num;
				} else if (operator == '^') {
					last = Math.pow(last, num);
				}
				num = 0;
				operator = c;
			}
		}

		return sum + last;
	}

	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
	}

	public double calculateSimpleIntrest(double principle, double time, double rate) {
		double sI = (principle * time * rate) / 100;
		return sI;
	}

	public double calculateRectangleArea(double length, double breadth) {
		return length * breadth;
	}

	public double calculateSquareArea(double side) {
		return side * side;
	}

	public double calculateCircleArea(double radius) {
		float pi = 3.14f;
		return pi * radius * radius;
	}

	public String calculateAge(LocalDate birthDay) {
		LocalDate currentDate = LocalDate.now();
		int age = Period.between(birthDay, currentDate).getYears();
		return "your age is " + age;
	}

	public double scientificCalculator(byte choice, double number) {
		switch (choice) {
		case 1:
			return Math.sqrt(number);
		case 2:
			return Math.log(number);
		case 3:
			return Math.log10(number);
		case 4:
			return Math.tan(number);
		case 5:
			return Math.cos(number);
		case 6:
			return Math.sin(number);
		case 7:
			return factorial(number);
		}
		return 0;
	}

	private double factorial(double number) {
		if (number <= 0.0) {
			return 1.0;
		}
		return number * factorial(number - 1);
	}

}
