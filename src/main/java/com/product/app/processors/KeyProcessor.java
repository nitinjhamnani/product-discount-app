package com.product.app.processors;

import java.util.List;

import org.springframework.stereotype.Component;

import com.product.app.enums.DataType;
import com.product.app.manger.ProductKeyManager;
import com.product.app.models.ProcessorConfig;
import com.product.app.models.ProductKeyValue;
import com.product.entities.ProductKeys;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KeyProcessor<T> implements BusinessProcessor<T> {

	private final ProductKeyManager productKeyManager;

	@Override
	public void process(List<ProcessorConfig<T>> configs) {
		for (ProcessorConfig<T> processorConfig : configs) {
			productKeyManager
					.save(buildProductKey(processorConfig.getKey(), 
							(ProductKeyValue) processorConfig.getValue()));
		}
	}

	private ProductKeys buildProductKey(String key, ProductKeyValue value) {
		return ProductKeys.builder().keyName(key)
				.dataType(DataType.valueOf(value.getDataType())).build();
	}

}
