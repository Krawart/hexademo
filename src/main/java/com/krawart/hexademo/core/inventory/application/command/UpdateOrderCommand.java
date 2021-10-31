package com.krawart.hexademo.core.inventory.application.command;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public record UpdateOrderCommand(
    @NotBlank String upc,
    @NotEmpty List<@Valid OrderItemDTO> items
) {
  public static record OrderItemDTO(
      @NotNull String medicineId,
      @NotNull @Min(1) Integer quantity
  ) {
  }
}
