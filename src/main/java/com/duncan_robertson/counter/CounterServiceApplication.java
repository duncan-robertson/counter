package com.duncan_robertson.counter;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CounterServiceApplication {
	Logger logger = LoggerFactory.getLogger(CounterServiceApplication.class);
	private int counter;

	public static void main(String[] args) {
		SpringApplication.run(CounterServiceApplication.class, args);
	}

	@GetMapping("/")
	public @ResponseBody CounterResponse counter() {
		return new CounterResponse(this.counter);
	}

	@PutMapping("/update")
	public @ResponseBody CounterResponse addCounter(@Valid @RequestBody UpdateRequest request) {		
		Operation operation = request.getOperation();
		
		if (operation == Operation.ADD) {
			this.counter++;
		} else if (operation == Operation.SUB) {
			this.counter--;
		}
		
		return new CounterResponse(this.counter);
	}
}
