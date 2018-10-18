package com.feedvisor.repricer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RepricerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepricerApplication.class, args);
	}
}
