package com.product.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class DiscountRules {
	//Assuming Rule name is unique - consider rule name as id
	private String ruleName;
	private List<ProductConditions> productConditions;
	private String expressionToEvaluate;
}
