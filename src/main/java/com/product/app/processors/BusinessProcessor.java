package com.product.app.processors;

import java.util.List;

import com.product.app.models.ProcessorConfig;

public interface BusinessProcessor<T> {

	void process(List<ProcessorConfig<T>> configs);
}
