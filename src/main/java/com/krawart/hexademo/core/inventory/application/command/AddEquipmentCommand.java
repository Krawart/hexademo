package com.krawart.hexademo.core.inventory.application.command;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public record AddEquipmentCommand(
    @NotBlank String name,
    @Min(1) Integer quantity
) {
}
