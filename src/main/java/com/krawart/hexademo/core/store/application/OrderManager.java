package com.krawart.hexademo.core.store.application;

import com.krawart.hexademo.common.application.ApplicationService;
import com.krawart.hexademo.core.store.application.command.AddOrderCommand;
import com.krawart.hexademo.core.store.application.command.UpdateOrderCommand;
import com.krawart.hexademo.core.store.domain.MedicineRepository;
import com.krawart.hexademo.core.store.domain.Order;
import com.krawart.hexademo.core.store.domain.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationService
@Transactional
@RequiredArgsConstructor
public class OrderManager {
    private final OrderRepository equipmentRepository;
    private final MedicineRepository medicineRepository;

    public Order add(AddOrderCommand command) {
        return equipmentRepository.add(mapAddCommandToDomain(command));
    }

    private Order mapAddCommandToDomain(AddOrderCommand command) {
        return Order.builder()
                .upc(command.upc())
                .items(command.items().stream()
                        .map(item -> Order.OrderItem.builder()
                                .medicine(medicineRepository.getById(UUID.fromString(item.medicineId())))
                                .quantity(item.quantity())
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }

    public Order update(UpdateOrderCommand command, UUID id) {
        var persistedEntity =
                equipmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));

        persistedEntity.setUpc(command.upc());
        persistedEntity.setItems(mapUpdateCommandItemsToDomain(command));

        return persistedEntity;
    }

    private Set<Order.OrderItem> mapUpdateCommandItemsToDomain(UpdateOrderCommand command) {
        return command.items().stream()
                .map(item -> Order.OrderItem.builder()
                        .medicine(medicineRepository.getById(UUID.fromString(item.medicineId())))
                        .quantity(item.quantity())
                        .build())
                .collect(Collectors.toSet());
    }

    public void deleteById(UUID id) {
        equipmentRepository.removeById(id);
    }
}
