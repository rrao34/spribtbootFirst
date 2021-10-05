package com.springboot.first.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springboot.first.*")
public class SpringBootFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstApplication.class, args);
	}

}
