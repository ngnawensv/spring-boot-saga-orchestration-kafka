package com.jts.inventory.dto;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class InventoryResponseDTO {
	private Integer userId;
	private Integer productId;
	private UUID orderId;
	private InventoryStatus status;

}
