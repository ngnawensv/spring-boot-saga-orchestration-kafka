package com.jts.order.dto;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class OrchestratorRequestDTO {
	private Integer userId;
	private Integer productId;
	private UUID orderId;
	private Double amount;
}
