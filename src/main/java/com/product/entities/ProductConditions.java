package com.product.entities;

import com.product.app.enums.OperationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class ProductConditions {
	private String conditionName;
	private ProductKeys productKeys;
	private OperationType operationType;
	private String value;
}
