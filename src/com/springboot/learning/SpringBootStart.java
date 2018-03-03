package com.springboot.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.springboot.learning"})
public class SpringBootStart {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStart.class, args);

	}

}
