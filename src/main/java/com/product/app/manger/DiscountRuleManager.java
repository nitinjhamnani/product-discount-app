package com.product.app.manger;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.product.entities.DiscountRules;

@Service
public class DiscountRuleManager implements DataManager<DiscountRules> {

	private static Map<String,DiscountRules> discountRuleMap=new HashMap<>();

	@Override
	public DiscountRules save(DiscountRules data) {
		discountRuleMap.put(data.getRuleName(), data);
		return data;
	}

	@Override
	public DiscountRules getById(String id) {
		return discountRuleMap.get(id);
	}
	
}
