package com.example.ev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class EvApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvApplication.class, args);
	}

}
