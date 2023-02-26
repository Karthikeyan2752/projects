package com.calculator;

import java.time.LocalDate;

public interface CalculatorModelCallBack {

	double calculate(String equation);

	double calculateSimpleIntrest(double principle, double time, double rate);

	double calculateRectangleArea(double length, double breadth);

	double calculateSquareArea(double side);

	double calculateCircleArea(double radius);

	String calculateAge(LocalDate birthDay);

	double scientificCalculator(byte choice, double number);

}
