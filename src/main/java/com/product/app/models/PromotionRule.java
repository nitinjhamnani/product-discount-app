package com.product.app.models;

import com.product.entities.Discount;
import com.product.entities.DiscountRules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PromotionRule {
	private DiscountRules discountRules;
	private Discount discount;
}
