package org.example.thortfultask.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.example.thortfultask.entity.Advice;
import org.example.thortfultask.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/advice")
@Validated
public class AdviceController {

	private final AdviceService adviceService;

	@Autowired
	public AdviceController(final AdviceService adviceService) {
		this.adviceService = adviceService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Mono<Advice>> getAdviceById(@PathVariable @Valid @Max(224) final Long id) {
		return new ResponseEntity<>(this.adviceService.getAdvice(id), HttpStatus.OK);
	}
}
