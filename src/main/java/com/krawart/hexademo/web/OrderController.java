package com.krawart.hexademo.web;

import com.krawart.hexademo.service.OrderService;
import com.krawart.hexademo.service.command.AddOrderCommand;
import com.krawart.hexademo.service.command.UpdateOrderCommand;
import com.krawart.hexademo.service.dto.OrderDTO;
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

  private final OrderService orderService;

  @PostMapping
  ResponseEntity<OrderDTO> addOrder(@RequestBody @Valid AddOrderCommand command) {
    var result = orderService.add(command);
    return ResponseEntity.created(URI.create("/api/v1/orders/" + result.getId())).build();
  }

  @PutMapping("/{id}")
  ResponseEntity<OrderDTO> updateOrder(@RequestBody @Valid UpdateOrderCommand command, @PathVariable UUID id) {
    var result = orderService.update(command, id);
    return ResponseEntity.ok(OrderDTO.of(result));
  }

  @GetMapping("/{id}")
  ResponseEntity<OrderDTO> getOrder(@PathVariable UUID id) {
    var result = orderService.getById(id);
    return ResponseEntity.ok(OrderDTO.of(result));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
    orderService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
