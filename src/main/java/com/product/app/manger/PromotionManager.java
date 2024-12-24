package com.product.app.manger;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.product.entities.PromotionSets;

@Component
public class PromotionManager implements DataManager<PromotionSets> {

	private static Map<String,PromotionSets> promotionssMap=new HashMap<>();

	@Override
	public PromotionSets save(PromotionSets data) {
		promotionssMap.put(data.getSetName(), data);
		return data;
	}

	@Override
	public PromotionSets getById(String id) {
		return promotionssMap.get(id);
	}
	

}
