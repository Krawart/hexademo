package com.krawart.hexademo.core.patient.application.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.Instant;

public record UpdatePetCommand(
    @PastOrPresent @NotNull Instant birthDate,
    @NotNull String name,
    @NotNull String ownerId
) {
}
