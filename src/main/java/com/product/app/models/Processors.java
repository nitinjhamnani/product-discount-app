package com.product.app.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Processors<T> {
	private int order;
	private String processor;
	private List<ProcessorConfig<T>> config;
}
