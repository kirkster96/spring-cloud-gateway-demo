package com.mpc.learn;


import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@GetMapping("/greeting")
	public ResponseEntity<Map<String, String>> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return ResponseEntity.ok(Map.of("status","hello from service a"));
	}


	@PostMapping("/greeting")
	public ResponseEntity<Map<String, String>> action(@RequestBody String body) {
		return ResponseEntity.ok(Map.of("status","hello from service a",
		"your-data",body));
	}
}
