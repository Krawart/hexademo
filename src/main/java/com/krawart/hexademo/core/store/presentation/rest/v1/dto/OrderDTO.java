package com.krawart.hexademo.core.store.presentation.rest.v1.dto;

import com.krawart.hexademo.core.store.domain.Order;
import com.krawart.hexademo.core.store.domain.Order.OrderItem;
import com.krawart.hexademo.core.store.presentation.rest.v1.dto.MedicineDTO.MedicineShortDTO;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record OrderDTO(String id, String name, List<OrderItemDTO> medicines) {
    public static OrderDTO of(Order entity) {
        return new OrderDTO(
                entity.getId().toString(),
                entity.getUpc(),
                entity.getItems().stream().map(OrderItemDTO::of).collect(Collectors.toList()));
    }

    public static record OrderItemDTO(MedicineShortDTO medicine, Integer quantity) {
        public static OrderItemDTO of(OrderItem item) {
            return new OrderItemDTO(MedicineShortDTO.of(item.getMedicine()), item.getQuantity());
        }
    }
}
