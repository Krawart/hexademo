package com.krawart.hexademo.core.store.application;

import com.krawart.hexademo.common.application.ApplicationService;
import com.krawart.hexademo.core.store.domain.Order;
import com.krawart.hexademo.core.store.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@ApplicationService
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderQueryService {
  private final OrderRepository orderRepository;

  public Order getById(UUID id) {
    return orderRepository.getById(id);
  }
}
