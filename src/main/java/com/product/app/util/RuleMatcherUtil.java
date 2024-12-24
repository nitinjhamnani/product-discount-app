package com.product.app.util;

import java.util.HashMap;
import java.util.Map;

import com.product.app.enums.OperationType;
import com.product.app.service.EqualsOperation;
import com.product.app.service.MainOperation;
import com.product.entities.DiscountRules;
import com.product.entities.Product;
import com.product.entities.ProductConditions;

public class RuleMatcherUtil {

	public static boolean matches(Product product,DiscountRules rules) {
		Map<String,Boolean> conditionMap = new HashMap<>();
		
		for(ProductConditions productConditions : rules.getProductConditions()) {
			String productValue = product.getProduct().get(productConditions.getProductKeys().getKeyName());
			MainOperation mainOperation = getOperation(productConditions.getOperationType());
			conditionMap.put(productConditions.getConditionName(),mainOperation.execute(productValue, productConditions.getValue())); 
			
		}
		return evaluateExpression(rules.getExpressionToEvaluate(),conditionMap);
	}

	//TODO implement this method based on expression as of now its working on or condition
	private static boolean evaluateExpression(String expressionToEvaluate, Map<String, Boolean> conditionMap) {
		for(String key: conditionMap.keySet()){
			if(conditionMap.get(key)) {
				return true;
			}
		}
		return false;
	}

	private static MainOperation getOperation(OperationType operationType) {
		if(OperationType.EQUALS.equals(operationType)) {
			return new EqualsOperation();
		}
		return null;
	}
}
