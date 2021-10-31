package com.krawart.hexademo.core.inventory.infrastructure;

import com.krawart.hexademo.core.inventory.domain.Order;
import com.krawart.hexademo.shared.infrastructure.HexaDemoJpaRepository;

interface OrderDAO extends HexaDemoJpaRepository<Order> {
}
