package com.product.app.calculator;

public class FlatCalculator implements Calculator {

	@Override
	public int calculate(int price, String value) {
		return Integer.valueOf(value);
	}

}
