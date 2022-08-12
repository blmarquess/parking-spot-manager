package com.api.parkingmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Parking manager application.
 */
@SpringBootApplication
@RestController
public class ParkingManagerApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ParkingManagerApplication.class, args);
	}

	/**
	 * Index string.
	 *
	 * @return the string
	 */
	@GetMapping("/")
	public String index() {
		return "hello peoples";
	}
}
