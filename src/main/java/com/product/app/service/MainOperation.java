package com.product.app.service;

@FunctionalInterface
public interface MainOperation {
	
	public boolean execute(String productValue, String ruleValue);

}
