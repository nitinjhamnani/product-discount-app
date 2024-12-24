package com.product.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.product.app.config.ConfigLoader;
import com.product.app.driver.Driver;

@SpringBootApplication
public class Application {
	
	@Autowired
	ConfigLoader configLoader;
	
	@Autowired
	Driver driver;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
	}
	
	public void run(String[] args) {
			configLoader.loadConfigs("product-config-1.json");
			driver.checkDiscountOnProducts("product-list-1.json", "Set A");
	}
}
	