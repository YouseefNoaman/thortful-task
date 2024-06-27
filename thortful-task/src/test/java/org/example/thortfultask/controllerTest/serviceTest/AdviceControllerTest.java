package org.example.thortfultask.controllerTest.serviceTest;

import org.example.thortfultask.controller.AdviceController;
import org.example.thortfultask.controller.GlobalExceptionHandler;
import org.example.thortfultask.entity.Advice;
import org.example.thortfultask.service.AdviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class AdviceControllerTest {

	private WebTestClient webTestClient;

	@Mock
	private AdviceService adviceService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);

		this.webTestClient = WebTestClient.bindToController(new AdviceController(this.adviceService))
				.controllerAdvice(new GlobalExceptionHandler()).build();
	}

	@Test
	public void testGetAdviceById() {
		// Mock service response
		final Advice mockAdvice = new Advice();
		mockAdvice.setId(1);
		mockAdvice.setAdvice("Remember that spiders are more afraid of you, than you are of them.");

		when(this.adviceService.getAdvice(anyLong())).thenReturn(Mono.just(mockAdvice));

		// Perform GET request and verify response
		this.webTestClient.get().uri("/api/v1/advice/1").exchange().expectStatus().isOk().expectBody().jsonPath("$.id")
				.isEqualTo(1).jsonPath("$.advice")
				.isEqualTo("Remember that spiders are more afraid of you, than you are of them.");
	}

}
