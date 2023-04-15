// Import required Spring Boot and Spring Web annotations
package com.ArpitSG;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// Declare the application as a Spring Boot application
@SpringBootApplication
// Declare the class as a REST controller to handle HTTP requests
@RestController
public class SampleApp {
	// Define a GET endpoint to return a message
	@GetMapping
	public String message(){
		return "welcome to Kaiburr Task 5";
	}
	// Define the entry point for the application
	public static void main(String[] args) {
		SpringApplication.run(SampleApp.class, args);
	}
}
// code modified by @Arpit Singh 19BCG10069