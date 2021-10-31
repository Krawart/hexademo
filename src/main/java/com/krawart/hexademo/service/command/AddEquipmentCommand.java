package com.krawart.hexademo.service.command;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public record AddEquipmentCommand(
    @NotBlank String name,
    @Min(1) Integer quantity
) {
}
