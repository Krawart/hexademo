package com.krawart.hexademo.core.supply.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.supply.domain.Order;
import com.krawart.hexademo.core.supply.domain.OrderRepository;
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
        return medicineDAO.save(OrderEntity.of(entity)).toDomain();
    }

    @Override
    public Order update(Order entity) {
        return medicineDAO.save(OrderEntity.of(entity)).toDomain();
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return medicineDAO.findById(id).map(OrderEntity::toDomain);
    }

    @Override
    public void removeById(UUID id) {
        medicineDAO.deleteById(id);
    }
}
