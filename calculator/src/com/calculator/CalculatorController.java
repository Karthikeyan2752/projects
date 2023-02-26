package com.calculator;

import java.time.LocalDate;

public class CalculatorController implements CalculatorControllerCallBack {

	private CalculatorModelCallBack calculatorModel;
	private CalculatorViewCallBack calculatorView;

	public CalculatorController(CalculatorViewCallBack calculatorView) {
		this.calculatorView = calculatorView;
		this.calculatorModel = new CalculatorModel(this);
	}

	@Override
	public double calculate(String equation) {
		return calculatorModel.calculate(equation);
	}

	@Override
	public double calculateSimpleIntrest(double principle, double time, double rate) {
		return calculatorModel.calculateSimpleIntrest(principle, time, rate);
	}

	@Override
	public double calculateRectangleArea(double length, double breadth) {
		return calculatorModel.calculateRectangleArea(length, breadth);
	}

	@Override
	public double calculateSquareArea(double side) {
		return calculatorModel.calculateSquareArea(side);
	}

	@Override
	public double calculateCircleArea(double radius) {
		return calculatorModel.calculateCircleArea(radius);
	}

	@Override
	public String calculateAge(LocalDate birthDay) {
		return calculatorModel.calculateAge(birthDay);

	}

	@Override
	public double scientificCalculator(byte choice, double number) {
		return calculatorModel.scientificCalculator(choice, number);
	}
}
