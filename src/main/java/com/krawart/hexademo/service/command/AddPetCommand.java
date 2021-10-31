package com.krawart.hexademo.service.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.Instant;

public record AddPetCommand(
    @PastOrPresent @NotNull Instant birthDate,
    @NotNull String name,
    @NotNull String ownerId
) {
}
