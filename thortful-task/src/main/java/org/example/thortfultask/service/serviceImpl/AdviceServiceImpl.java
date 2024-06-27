package org.example.thortfultask.service.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.thortfultask.entity.Advice;
import org.example.thortfultask.entity.AdviceResponse;
import org.example.thortfultask.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class AdviceServiceImpl implements AdviceService {

	private final WebClient webClient;

	@Autowired
	public AdviceServiceImpl(final WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://api.adviceslip.com").build();
	}

	@Cacheable(value = "advices", key = "#id")
	@Override
	public Mono<Advice> getAdvice(final Long id) {
		return this.webClient.get().uri("/advice/{id}", id).retrieve().bodyToMono(String.class)
				.doOnNext(response -> log.info("Raw response: {}", response)).<Advice>handle((response, sink) -> {
					// Manually parse the JSON for debugging
					try {
						final ObjectMapper objectMapper = new ObjectMapper();
						final AdviceResponse adviceResponse = objectMapper.readValue(response, AdviceResponse.class);
						sink.next(adviceResponse.getSlip());
					} catch (final JsonProcessingException e) {
						log.error("Error parsing JSON response", e);
						sink.error(new RuntimeException("Error parsing JSON response", e));
					}
				}).doOnError(error -> log.error("Error fetching advice", error));
	}

}
