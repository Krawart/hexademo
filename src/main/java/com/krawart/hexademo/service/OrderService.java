package com.krawart.hexademo.service;

import com.krawart.hexademo.domain.Order;
import com.krawart.hexademo.service.command.AddOrderCommand;
import com.krawart.hexademo.service.command.UpdateOrderCommand;

import java.util.UUID;

public interface OrderService {
  Order add(AddOrderCommand command);

  Order update(UpdateOrderCommand command, UUID id);

  Order getById(UUID id);

  void deleteById(UUID id);
}
