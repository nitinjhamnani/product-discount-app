package com.product.entities;

import java.util.List;

import com.product.app.enums.SetReturnType;
import com.product.app.enums.State;
import com.product.app.models.PromotionRule;

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
public class PromotionSets {
	private List<PromotionRule> promotionRules;
	private String setName;
	private State promotionSetState;
	private SetReturnType setReturnType;
}
