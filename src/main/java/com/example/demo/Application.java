package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Driver class.
 */
@SpringBootApplication
@EnableScheduling
public class Application {

	/**
	 * Driver function.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
