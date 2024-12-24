package com.product.entities;

import com.product.app.enums.DataType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductKeys {
	//Assuming key name is unique - consider key name as id
	private String keyName;
	private DataType dataType;
}
