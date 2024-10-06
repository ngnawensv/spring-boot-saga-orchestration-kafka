package com.jts.order.entity;

import java.util.UUID;

import lombok.Data;
import org.springframework.data.annotation.Id;

import com.jts.order.dto.OrderStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class PurchaseOrder {
	@Id
	private UUID id;
	private Integer userId;
	private Integer productId;
	private Double price;
	private OrderStatus status;

}