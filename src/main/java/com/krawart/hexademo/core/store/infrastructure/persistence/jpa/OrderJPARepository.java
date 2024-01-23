package com.krawart.hexademo.core.store.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.store.domain.Order;
import com.krawart.hexademo.core.store.domain.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class OrderJPARepository implements OrderRepository {

  private final OrderDAO medicineDAO;

  @Override
  public Order add(Order entity) {
    return medicineDAO.save(entity);
  }

  @Override
  public Order update(Order entity) {
    return medicineDAO.save(entity);
  }

  @Override
  public Optional<Order> findById(UUID id) {
    return medicineDAO.findById(id);
  }

  @Override
  public Order getById(UUID id) {
    return medicineDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found in database"));
  }

  @Override
  public void removeById(UUID id) {
    medicineDAO.deleteById(id);
  }
}
