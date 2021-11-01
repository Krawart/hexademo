package com.krawart.hexademo.core.inventory.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.inventory.domain.Order;
import com.krawart.hexademo.shared.infrastructure.persistence.HexaDemoJpaRepository;

interface OrderDAO extends HexaDemoJpaRepository<Order> {
}
