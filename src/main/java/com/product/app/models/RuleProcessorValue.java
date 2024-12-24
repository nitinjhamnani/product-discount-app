package com.product.app.models;

import com.product.app.enums.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleProcessorValue {
	private String productKey;
	private OperationType operation;
	private String value;
}
