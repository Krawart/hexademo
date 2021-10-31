package com.krawart.hexademo.service.impl;

import com.krawart.hexademo.domain.Order;
import com.krawart.hexademo.repository.MedicineRepository;
import com.krawart.hexademo.repository.OrderRepository;
import com.krawart.hexademo.service.OrderService;
import com.krawart.hexademo.service.command.AddOrderCommand;
import com.krawart.hexademo.service.command.UpdateOrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final OrderRepository equipmentRepository;
  private final MedicineRepository medicineRepository;

  @Override
  public Order add(AddOrderCommand command) {
    return equipmentRepository.save(mapAddCommandToDomain(command));
  }

  private Order mapAddCommandToDomain(AddOrderCommand command) {
    return Order.builder()
        .upc(command.upc())
        .items(
            command.items().stream()
                .map(item -> Order.OrderItem.builder()
                    .medicine(medicineRepository.getById(UUID.fromString(item.medicineId())))
                    .quantity(item.quantity())
                    .build()
                )
                .collect(Collectors.toSet())
        )
        .build();
  }

  @Override
  public Order update(UpdateOrderCommand command, UUID id) {
    var persistedEntity = equipmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));

    persistedEntity.setUpc(command.upc());
    persistedEntity.setItems(mapUpdateCommandItemsToDomain(command));

    return persistedEntity;
  }

  private Set<Order.OrderItem> mapUpdateCommandItemsToDomain(UpdateOrderCommand command) {
    return command.items().stream()
        .map(item -> Order.OrderItem.builder()
            .medicine(medicineRepository.getById(UUID.fromString(item.medicineId())))
            .quantity(item.quantity())
            .build()
        )
        .collect(Collectors.toSet());
  }

  @Override
  public Order getById(UUID id) {
    return equipmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));
  }

  @Override
  public void deleteById(UUID id) {
    equipmentRepository.deleteById(id);
  }
}
