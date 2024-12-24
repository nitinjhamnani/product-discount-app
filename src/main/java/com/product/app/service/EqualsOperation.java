package com.product.app.service;

public class EqualsOperation implements MainOperation {

	@Override
	public boolean execute(String productValue, String ruleValue) {
		return productValue.equals(ruleValue);
	}
}
