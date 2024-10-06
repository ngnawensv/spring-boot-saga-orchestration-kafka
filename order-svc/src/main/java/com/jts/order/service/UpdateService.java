package com.jts.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jts.order.dto.OrchestratorResponseDTO;
import com.jts.order.repo.PurchaseOrderRepository;

import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UpdateService {
	private final PurchaseOrderRepository repo;

    public UpdateService(PurchaseOrderRepository repo) {
        this.repo = repo;
    }

    public Mono<Void> updateOrder(OrchestratorResponseDTO responseDTO) {
		System.out.println("Response::"+responseDTO.getStatus());
		
		return repo.findById(responseDTO.getOrderId())
		.doOnNext(p -> p.setStatus(responseDTO.getStatus()))
		.doOnNext(repo::save)
		.then();
	}
}
