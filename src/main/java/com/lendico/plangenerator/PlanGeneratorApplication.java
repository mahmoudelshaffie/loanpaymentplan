package com.lendico.plangenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.lendico.plangenerator.*")
public class PlanGeneratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlanGeneratorApplication.class, args);
	}
}
