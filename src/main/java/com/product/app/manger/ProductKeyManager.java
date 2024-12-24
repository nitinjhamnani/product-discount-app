package com.product.app.manger;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.product.entities.ProductKeys;

@Service
public class ProductKeyManager implements DataManager<ProductKeys> {
	
	private static Map<String,ProductKeys> productKeysMap=new HashMap<String,ProductKeys>();
	
	@Override
	public ProductKeys save(ProductKeys data) {
		productKeysMap.put(data.getKeyName(), data);
		return data;
	}

	@Override
	public ProductKeys getById(String id) {
		return productKeysMap.get(id);
	}
	

}
