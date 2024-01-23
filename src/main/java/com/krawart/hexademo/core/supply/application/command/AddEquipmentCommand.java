package com.krawart.hexademo.core.supply.application.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AddEquipmentCommand(@NotBlank String name, @Min(1) Integer quantity) {}
