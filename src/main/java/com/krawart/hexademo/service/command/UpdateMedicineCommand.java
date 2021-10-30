package com.krawart.hexademo.service.command;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public record UpdateMedicineCommand(
    @NotBlank String name,
    @Min(1) Double weight
) {
}
