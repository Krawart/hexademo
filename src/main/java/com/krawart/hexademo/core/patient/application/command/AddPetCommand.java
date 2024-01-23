package com.krawart.hexademo.core.patient.application.command;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.Instant;

public record AddPetCommand(
    @PastOrPresent @NotNull Instant birthDate,
    @NotNull String name,
    @NotNull String ownerId
) {
}
