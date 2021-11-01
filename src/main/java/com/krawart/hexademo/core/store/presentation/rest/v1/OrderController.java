package com.krawart.hexademo.core.store.presentation.rest.v1;

import com.krawart.hexademo.core.store.application.OrderManager;
import com.krawart.hexademo.core.store.application.OrderQueryService;
import com.krawart.hexademo.core.store.application.command.AddOrderCommand;
import com.krawart.hexademo.core.store.application.command.UpdateOrderCommand;
import com.krawart.hexademo.core.store.presentation.rest.v1.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
class OrderController {

  private final OrderManager orderManager;
  private final OrderQueryService orderQueryService;

  @PostMapping
  ResponseEntity<OrderDTO> addOrder(@RequestBody @Valid AddOrderCommand command) {
    var result = orderManager.add(command);
    return ResponseEntity.created(URI.create("/api/v1/orders/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<OrderDTO> updateOrder(@RequestBody @Valid UpdateOrderCommand command, @PathVariable UUID id) {
    var result = orderManager.update(command, id);
    return ResponseEntity.ok(OrderDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<OrderDTO> getOrder(@PathVariable UUID id) {
    var result = orderQueryService.getById(id);
    return ResponseEntity.ok(OrderDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
    orderManager.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
