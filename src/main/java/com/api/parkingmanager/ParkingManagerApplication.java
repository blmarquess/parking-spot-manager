package com.api.parkingmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkingManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingManagerApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "hello peoples";
	}
}
