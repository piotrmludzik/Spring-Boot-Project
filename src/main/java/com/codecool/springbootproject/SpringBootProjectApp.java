package com.codecool.springbootproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootProjectApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApp.class, args);
		log.info("starting the app");
	}

}
