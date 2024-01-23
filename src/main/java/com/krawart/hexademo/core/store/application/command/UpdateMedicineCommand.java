package com.krawart.hexademo.core.store.application.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UpdateMedicineCommand(@NotBlank String name, @Min(1) Double weight) {}
