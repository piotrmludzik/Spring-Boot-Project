package com.codecool.springbootproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Slf4j
@SpringBootApplication
public class SpringbootprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootprojectApplication.class, args);
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		context.close();
	}
}
