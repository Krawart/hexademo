package com.krawart.hexademo.core.store.application.command;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AddOrderCommand(@NotBlank String upc, @NotEmpty List<@Valid OrderItemDTO> items) {
    public static record OrderItemDTO(@NotNull String medicineId, @NotNull @Min(1) Integer quantity) {}
}
