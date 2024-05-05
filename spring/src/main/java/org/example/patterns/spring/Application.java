package org.example.patterns.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


// Tests how inject only req.beans in test context:
// 1. Create test env. config with:
/*
@Configuration
@ComponentScan(lazyInit = true) => this create context with all beans in lazy mode. Use lazy scanning
public TestConfig () { ... }
 */
// also you can use this in application.yml:
/*
spring:
	main:
		lazy-initialization: true
 */