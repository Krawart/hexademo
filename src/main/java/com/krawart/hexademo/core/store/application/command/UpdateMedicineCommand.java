package com.krawart.hexademo.core.store.application.command;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public record UpdateMedicineCommand(
    @NotBlank String name,
    @Min(1) Double weight
) {
}
