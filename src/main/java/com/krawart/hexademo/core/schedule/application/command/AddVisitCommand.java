package com.krawart.hexademo.core.schedule.application.command;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.Instant;

public record AddVisitCommand(
    @Future @NotNull Instant date,
    String description,
    @NotNull String petId
) {
}
