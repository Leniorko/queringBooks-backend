package com.leniorko.usingbooksapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UsingBooksApiApplication {

	@GetMapping("/")
	String home() {
		return "Server is up and running.";
	}

	public static void main(String[] args) {
		SpringApplication.run(UsingBooksApiApplication.class, args);
	}

}
