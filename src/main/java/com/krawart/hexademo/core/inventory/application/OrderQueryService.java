package com.krawart.hexademo.core.inventory.application;

import com.krawart.hexademo.core.inventory.domain.Order;
import com.krawart.hexademo.core.inventory.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderQueryService {
  private final OrderRepository orderRepository;

  public Order getById(UUID id) {
    return orderRepository.getById(id);
  }
}
