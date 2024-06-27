package org.example.thortfultask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ThortfulTaskApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ThortfulTaskApplication.class, args);
	}

}
