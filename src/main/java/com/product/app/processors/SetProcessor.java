package com.product.app.processors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.product.app.enums.DiscountType;
import com.product.app.enums.SetReturnType;
import com.product.app.enums.State;
import com.product.app.manger.DiscountRuleManager;
import com.product.app.manger.PromotionManager;
import com.product.app.models.ProcessorConfig;
import com.product.app.models.PromotionRule;
import com.product.app.models.SetProcessorValue;
import com.product.app.models.SetRules;
import com.product.entities.Discount;
import com.product.entities.DiscountRules;
import com.product.entities.PromotionSets;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SetProcessor<T> implements BusinessProcessor<T> {

	private final PromotionManager promotionManager;
	private final DiscountRuleManager discountRuleManager;

	@Override
	public void process(List<ProcessorConfig<T>> configs) {
		for (ProcessorConfig<T> processorConfig : configs) {
			SetProcessorValue setProcessorValue = (SetProcessorValue) processorConfig.getValue();
			promotionManager.save(buildPromotion(processorConfig.getKey(), setProcessorValue));
		}
	}

	private PromotionSets buildPromotion(String key, SetProcessorValue setProcessorValue) {
		List<PromotionRule> promotionRule = createPromotionRuleList(setProcessorValue.getRules());
		return PromotionSets.builder().setName(key).promotionRules(promotionRule).promotionSetState(State.ACTIVE)
				.setReturnType(SetReturnType.valueOf(setProcessorValue.getReturnType())).build();
	}

	private List<PromotionRule> createPromotionRuleList(List<SetRules> rules) {
		List<PromotionRule> promotionRules = new ArrayList<>();
		for (SetRules rule : rules) {
			DiscountRules discountRule = discountRuleManager.getById(rule.getRuleName());
			Discount discount = Discount.builder().discountType(DiscountType.valueOf(rule.getDiscountType()))
					.discountValue(rule.getDiscountValue()).build();
			promotionRules.add(PromotionRule.builder().discount(discount).discountRules(discountRule).build());
		}
		return promotionRules;
	}

}
