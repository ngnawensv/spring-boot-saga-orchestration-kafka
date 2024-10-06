package com.jts.order.consumer;

import java.util.function.Consumer;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jts.order.dto.OrchestratorRequestDTO;
import com.jts.order.dto.OrchestratorResponseDTO;
import com.jts.order.service.UpdateService;

import reactor.core.publisher.Flux;

@Configuration
@Slf4j
public class OrderConsumer {
	private final Flux<OrchestratorRequestDTO> flux;
	private final UpdateService update;

    public OrderConsumer(Flux<OrchestratorRequestDTO> flux, UpdateService update) {
        this.flux = flux;
        this.update = update;
    }

    @Bean
	public Supplier<Flux<OrchestratorRequestDTO>> supplier() {
		return () -> flux;
	}
	
	@Bean
	public Consumer<Flux<OrchestratorResponseDTO>> consumer() {
		return c -> c
				.doOnNext(a -> log.info("Cosuming:: {}", a))
				.flatMap(update::updateOrder)
                .subscribe();
	};
	
}
