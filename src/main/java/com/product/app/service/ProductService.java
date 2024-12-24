package com.product.app.service;

import java.util.List;

import com.product.entities.Product;

public interface ProductService {
	
	void process(List<Product> products, String promotionSet);
}
