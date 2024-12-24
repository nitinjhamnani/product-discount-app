package com.product.app.strategy;

import java.util.List;

import com.product.app.calculator.Calculator;
import com.product.app.calculator.FlatCalculator;
import com.product.app.enums.DiscountType;
import com.product.app.models.PromotionRule;
import com.product.app.util.RuleMatcherUtil;
import com.product.entities.Discount;
import com.product.entities.Product;

public class MaxDiscountStrategy implements Strategy {

	@Override
	public void applyStrategy(Product product, List<PromotionRule> promotionRules) {
		int maxDiscount = 0;
		for(PromotionRule rule : promotionRules) {
			if(RuleMatcherUtil.matches(product, rule.getDiscountRules())) {
				int discount = calculateDiscount(product.getProduct().get("price"), rule.getDiscount());
				maxDiscount = Math.max(maxDiscount, discount);
			}
		}
		product.getProduct().put("discount", String.valueOf(maxDiscount));
	}

	private int calculateDiscount(String price , Discount discount) {
		Calculator calculator = getCalculator(discount.getDiscountType());
		return calculator.calculate(Integer.valueOf(price), discount.getDiscountValue());
	}

	//TO be replaced by factory
	private Calculator getCalculator(DiscountType discountType) {
		if(DiscountType.FLAT.equals(discountType)) {
			return new FlatCalculator();
		}
		return null;
	}
	
}
