package com.devonfw.app.java.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.devonfw.module.jpa.dataaccess.api.AdvancedRevisionEntity;
import com.devonfw.module.jpa.dataaccess.impl.data.GenericRepositoryFactoryBean;
import com.devonfw.module.json.common.base.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/**
 * Main entry point of this {@link SpringBootApplication}. Simply run this class
 * to start this app.
 */
@SpringBootApplication(scanBasePackageClasses = {SpringBootApp.class, AppConfig.class})
@EntityScan(basePackages = { "com.devonfw.app.java.order" }, basePackageClasses = { AdvancedRevisionEntity.class })
@EnableJpaRepositories(repositoryFactoryBeanClass = GenericRepositoryFactoryBean.class)
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SpringBootApp {

	/**
	 * Entry point for spring-boot based app
	 *
	 * @param args - arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(SpringBootApp.class, args);
	}

}
