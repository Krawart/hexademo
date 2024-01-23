package com.krawart.hexademo.core.supply.infrastructure.persistence.jpa;

import com.krawart.hexademo.shared.infrastructure.persistence.jpa.SpringDataJpaDAO;
import org.springframework.stereotype.Component;

@Component
interface MedicineDAO extends SpringDataJpaDAO<MedicineEntity> {}
