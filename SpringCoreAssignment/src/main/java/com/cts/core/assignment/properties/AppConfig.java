package com.cts.core.assignment.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:manager.properties")
public class AppConfig {

	@Bean
	public Manager manager() {
		return new Manager();
	}
}
