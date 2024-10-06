package com.jts.saga.config;

import java.util.function.Function;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jts.saga.common.OrchestratorRequestDTO;
import com.jts.saga.common.OrchestratorResponseDTO;
import com.jts.saga.service.OrchestratorService;

import reactor.core.publisher.Flux;

@Configuration
@Slf4j
@Data
public class OrchestratorConfig {
	private final OrchestratorService orchestratorService;

    public OrchestratorConfig(OrchestratorService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }

    @Bean
	public Function<Flux<OrchestratorRequestDTO>, Flux<OrchestratorResponseDTO>> processor() {
		return flux -> flux.flatMap(orchestratorService::orderProduct)
				.doOnNext(dto -> log.info("Status : {}" , dto.getStatus()));
	}

}
