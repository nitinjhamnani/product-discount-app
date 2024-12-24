package com.product.app.processors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.product.app.enums.OperationType;
import com.product.app.manger.DiscountRuleManager;
import com.product.app.manger.ProductKeyManager;
import com.product.app.models.ProcessorConfig;
import com.product.app.models.RuleConditions;
import com.product.app.models.RuleConditionsValue;
import com.product.entities.DiscountRules;
import com.product.entities.ProductConditions;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RuleProcessor<T> implements BusinessProcessor<T> {

	private final DiscountRuleManager discountRuleManager;
	private final ProductKeyManager productKeyManager;

	@Override
	public void process(List<ProcessorConfig<T>> configs) {
		for (ProcessorConfig<T> processorConfig : configs) {
			RuleConditionsValue ruleConditionsValues = (RuleConditionsValue) processorConfig.getValue();
			discountRuleManager.save(buildDiscountRule(processorConfig.getKey(), ruleConditionsValues));
		}

	}
	
	private DiscountRules buildDiscountRule(String key, RuleConditionsValue ruleConditionsValue) {
		List<ProductConditions> productConditions = getProductConditions(ruleConditionsValue.getConditions());
		return DiscountRules.builder().ruleName(key).expressionToEvaluate(ruleConditionsValue.getExpression())
				.productConditions(productConditions).build();
	}

	private List<ProductConditions> getProductConditions(List<RuleConditions> ruleConditions) {
		List<ProductConditions> productConditions = new ArrayList<>();
		for (RuleConditions conditions : ruleConditions) {
			productConditions.add(ProductConditions.builder().conditionName(conditions.getCondition())
					.operationType(OperationType.valueOf(conditions.getOperation()))
					.productKeys(productKeyManager.getById(conditions.getProductKey()))
					.value(conditions.getValue())
					.build());

		}
		return productConditions;
	}

}
