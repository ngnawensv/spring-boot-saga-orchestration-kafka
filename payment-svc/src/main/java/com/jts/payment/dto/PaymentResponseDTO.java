package com.jts.payment.dto;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class PaymentResponseDTO {
	private Integer userId;
	private UUID orderId;
	private Double amount;
	private PaymentStatus status;
}
