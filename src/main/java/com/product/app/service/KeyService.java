package com.product.app.service;

import com.product.entities.ProductKeys;

public interface KeyService {
	
	ProductKeys create(String name , String type);
	ProductKeys get(String name);

}
