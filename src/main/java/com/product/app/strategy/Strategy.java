package com.product.app.strategy;

import java.util.List;

import com.product.app.models.PromotionRule;
import com.product.entities.Product;

public interface Strategy {

	void applyStrategy(Product product , List<PromotionRule> promotionRules);
}
