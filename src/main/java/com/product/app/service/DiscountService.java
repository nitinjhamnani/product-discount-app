package com.product.app.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.product.app.enums.SetReturnType;
import com.product.app.manger.PromotionManager;
import com.product.app.strategy.MaxDiscountStrategy;
import com.product.app.strategy.Strategy;
import com.product.entities.Product;
import com.product.entities.PromotionSets;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiscountService implements ProductService {

	private final PromotionManager promotionManager;
	
	@Override
	public void process(List<Product> products, String promotionSet) {
		PromotionSets promotionSets = promotionManager.getById(promotionSet);
		Strategy strategey =  getStrategy(promotionSets.getSetReturnType());
		if (Objects.nonNull(promotionSets)) {
			for (Product product : products) {
				try {
					strategey.applyStrategy(product, promotionSets.getPromotionRules());
					log.info("Applied Discount - {}" , product);
				} catch (Exception e) {
					log.error("Error While Applying Strategy To Product - {}",product);
				}
			}
		}else {
			log.error("No Promotion Foung For Set - {}",promotionSet);
		}
	}
	
	//This method to be replaced by a factory class.
	private Strategy getStrategy(SetReturnType setReturnType) {
		if(SetReturnType.MAX_DISCOUNT.equals(setReturnType)) {
			return new MaxDiscountStrategy();
		}
		return null;
	}

}
