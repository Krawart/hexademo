package com.krawart.hexademo.service.command;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.Instant;

public record UpdateVisitCommand(
    @Future @NotNull Instant date,
    String description,
    @NotNull String petId
) {
}
