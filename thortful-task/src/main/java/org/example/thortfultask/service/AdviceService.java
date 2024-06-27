package org.example.thortfultask.service;

import org.example.thortfultask.entity.Advice;
import reactor.core.publisher.Mono;

public interface AdviceService {
	Mono<Advice> getAdvice(final Long id);
}
