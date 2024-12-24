package com.product.app.driver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.app.service.DiscountService;
import com.product.entities.Product;

@Configuration
public class Driver {

	@Autowired
	private DiscountService discountService;
	
	public List<Product> checkDiscountOnProducts(String productFile,String promotionSet) {
		ObjectMapper mapper = new ObjectMapper();
		List<Product> products = new ArrayList<>();
		try {
		    products = mapper.readValue(new File("../src/main/resources/" + productFile), List.class);
		    discountService.process(products,promotionSet);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return products;
	}
	
}
