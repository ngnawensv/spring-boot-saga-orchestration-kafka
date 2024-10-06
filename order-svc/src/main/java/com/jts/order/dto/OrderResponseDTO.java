package com.jts.order.dto;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class OrderResponseDTO {
	private UUID orderId;
	private Integer userId;
	private Integer productId;
	private Double amount;
	private OrderStatus status;
}
