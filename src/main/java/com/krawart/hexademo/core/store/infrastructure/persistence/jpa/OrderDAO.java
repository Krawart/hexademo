package com.krawart.hexademo.core.store.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.store.domain.Order;
import com.krawart.hexademo.shared.infrastructure.persistence.HexaDemoJpaRepository;
import org.springframework.stereotype.Component;

@Component
interface OrderDAO extends HexaDemoJpaRepository<Order> {}
