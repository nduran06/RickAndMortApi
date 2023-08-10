package com.app.rickandmorthy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.app.rickandmorthy"})
public class RickandmorthyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RickandmorthyApplication.class, args);
	}

}
