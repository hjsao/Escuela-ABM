package com.school.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = { "com.school.models" })
@SpringBootApplication(scanBasePackages={
"com.school.project,"+"com.school.controllers,"+"com.school.models,"+"com.school.repositories,"+"com.school.services"})
@EnableJpaRepositories("com.school.repositories")
public class SchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

}
