package com.product.app.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetProcessorValue {
	private List<SetRules> rules;
	private String returnType;
}
