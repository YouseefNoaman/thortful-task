// package org.example.thortfultask.serviceTest;
//
// import org.example.thortfultask.controller.AdviceController;
// import org.example.thortfultask.controller.GlobalExceptionHandler;
// import org.example.thortfultask.entity.Advice;
// import org.example.thortfultask.service.serviceImpl.AdviceServiceImpl;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.reactive.server.WebTestClient;
// import org.springframework.web.reactive.function.client.ClientResponse;
// import org.springframework.web.reactive.function.client.WebClient;
// import reactor.core.publisher.Mono;
// import reactor.test.StepVerifier;
//
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
//
// public class AdviceServiceTest {
//
// private AdviceServiceImpl adviceServiceImpl;
//
// @Mock
// private WebClient.Builder webClientBuilder;
//
// @Mock
// private WebClient webClient;
//
// private WebTestClient webTestClient;
//
// @BeforeEach
// public void setup() {
// MockitoAnnotations.openMocks(this);
//
// this.adviceServiceImpl = new AdviceServiceImpl(this.webClientBuilder);
//
// this.webTestClient = WebTestClient.bindToController(new
// AdviceController(this.adviceServiceImpl))
// .controllerAdvice(new GlobalExceptionHandler()).build();
// }
//
// @Test
// public void testGetAdvice() throws Exception {
// // Mock WebClient behavior
// when(this.webClientBuilder.baseUrl(any())).thenReturn(this.webClientBuilder);
// when(this.webClientBuilder.build()).thenReturn(this.webClient);
//
// final ClientResponse mockResponse = ClientResponse.create(HttpStatus.OK)
// .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
// .body("{\"slip\":{\"id\":1,\"advice\":\"Test advice\"}}")
// .build();
// when(this.webClient.get()).thenReturn(this.webClient.get());
// when(this.webClient.uri(any())).thenReturn(this.webClient.uri("/advice/{id}",
// 1L));
// when(this.webClient.retrieve()).thenReturn(this.webClient.retrieve());
// when(this.webClient.bodyToMono(String.class)).thenReturn(Mono.just("{\"slip\":{\"id\":1,\"advice\":\"Test
// advice\"}}"));
// when(this.webClient.get().uri("/advice/{id}",
// 1).exchange()).thenReturn(Mono.just(mockResponse));
//
// // Invoke service method
// final Mono<Advice> adviceMono = this.adviceServiceImpl.getAdvice(1L);
//
// // Verify response using StepVerifier
// StepVerifier.create(adviceMono)
// .expectNextMatches(advice -> advice.getId() == 1 &&
// advice.getAdvice().equals("Test advice"))
// .verifyComplete();
// }
// }
