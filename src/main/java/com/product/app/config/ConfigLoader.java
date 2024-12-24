package com.product.app.config;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.app.models.AppConfig;
import com.product.app.models.Processors;
import com.product.app.processors.BusinessProcessor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ConfigLoader {
	
	@Autowired private Map<String, BusinessProcessor> processorMap;
	
	public void loadConfigs(String configName) {
		ObjectMapper mapper = new ObjectMapper();
		try {
		    AppConfig appConfig = mapper.readValue(new File("../src/main/resources/" + configName), AppConfig.class);
		    for(Processors processor : appConfig.getProcessors()) {
		    	processorMap.get(processor.getProcessor()).process(processor.getConfig());
		    }
		    log.info("Loaded Config ->" , appConfig);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}
