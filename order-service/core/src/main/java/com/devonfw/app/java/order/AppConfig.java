package com.devonfw.app.java.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devonfw.module.json.common.base.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Configuration
public class AppConfig {

	@Bean
	public ObjectMapperFactory objectMapperFactory() {
		return new ObjectMapperFactory();
	}

	@Bean
	public JacksonJsonProvider jacksonJsonProvider() {
		ObjectMapper objectMapper = new ObjectMapperFactory().createInstance().registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return new JacksonJsonProvider(objectMapper);
	}
}
