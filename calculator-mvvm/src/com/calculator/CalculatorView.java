package com.calculator;

import java.time.LocalDate;
import java.util.Scanner;

import com.util.UIValidator;

public class CalculatorView {

	private Scanner scanner = new Scanner(System.in);
	private CalculatorViewModel calculatorViewModel;

	public CalculatorView() {
		this.calculatorViewModel = new CalculatorViewModel(this);
	}

	public void mainPage() {
		System.out.println("\tCALCULATOR\n");
		System.out.println("Enter 1 for simple intrest calculator");
		System.out.println("Enter 2 for arithmetic calculator");
		System.out.println("Enter 3 for scientific calculator");
		System.out.println("Enter 4 for area calculator");
		System.out.println("Enter 5 for age calculator");
		System.out.println("Enter 0 to exit\n");
		getChoiceAndProceed();
	}

	private void getChoiceAndProceed() {
		byte choice = UIValidator.getChoice();

		switch (choice) {
		case 1:
			simpleIntrestCalculator();
			break;
		case 2:
			arithmeticCalculator();
			break;
		case 3:
			scientificCalculator();
			break;
		case 4:
			areaCalculator();
			break;
		case 5:
			ageCalculator();
			break;
		default:
			System.out.println("Exitting..");
			return;
		}
	}

	private void ageCalculator() {
		System.out.println("Enter your date of birth : (yyyy-mm-dd)");
		LocalDate birthDay = UIValidator.getDateFromUser();
		String result = calculatorViewModel.calculateAge(birthDay);
		System.out.println(result);
		mainPage();
	}

	private void areaCalculator() {
		System.out.println("Enter 1 to calculate the area of circle ");
		System.out.println("Enter 2 to calculate the area of square");
		System.out.println("Enter 3 to calculate the area of rectangle");
		byte choice = UIValidator.getChoice();
		double area =0;
		if(choice==2) {
			System.out.println("Enter the length of a side of square : \n");
			double side = scanner.nextDouble();
			area = calculatorViewModel.calculateSquareArea(side);
			System.out.println("area = " + area);
		}else if(choice==1) {
			System.out.println("Enter the radius of circle : \n");
			double radius = scanner.nextDouble();
			area = calculatorViewModel.calculateCircleArea(radius);
			System.out.println("area = " + area);
		}else if(choice==3) {
			System.out.println("Enter the length of the rectangle : \n");
			double length = scanner.nextDouble();
			System.out.println("Enter the breadth of the rectangle  : \n");
			double breadth = scanner.nextDouble();
			area = calculatorViewModel.calculateRectangleArea(length, breadth);
			System.out.println("area = "+area);
		}
		mainPage();
	}

	private void scientificCalculator() {
		System.out.println("Enter 1 to calculate square root of number ");
		System.out.println("Enter 2 to calculate log of a number");
		System.out.println("Enter 3 to calculate log10 of a number");
		System.out.println("Enter 4 to calculate tan of a number");
		System.out.println("Enter 5 to calculate cos of a number");
		System.out.println("Enter 6 to calculate sin of a number");
		System.out.println("Enter 7 to calculate factorial of a number\n");
		byte choice = UIValidator.getChoice();
		System.out.println("Enter the number : \n");
		double number = scanner.nextDouble();
		double result = calculatorViewModel.scientificCalculator(choice, number);
		System.out.println(result);
		mainPage();
	}

	private void arithmeticCalculator() {
		System.out.println("Use '+' for addition");
		System.out.println("Use '-' for subraction");
		System.out.println("Use '*' for multiplication");
		System.out.println("Use '/'for division");
		System.out.println("Use '^' for power\n");
		System.out.println("Enter the equation : (like : 3+5-9/4*4)\n");
		String equation = scanner.next();
		double result = calculatorViewModel.calculate(equation);
		System.out.println(equation + " = " + result);
		mainPage();
	}

	private void simpleIntrestCalculator() {
		System.out.println("Enter the principal (in rupees): \n");
		double principal = scanner.nextDouble();
		System.out.println("Enter the time (in units)\n");
		double time = scanner.nextDouble();
		System.out.println("Enter the rate (in %)\n");
		double rate = scanner.nextDouble();
		double result = calculatorViewModel.calculateSimpleIntrest(principal, time, rate);
		System.out.println("simple intrest = " + result);
		mainPage();
	}
}
