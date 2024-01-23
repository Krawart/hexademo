package com.krawart.hexademo.core.patient.infrastructure.persistence.jpa;

import com.krawart.hexademo.shared.infrastructure.persistence.jpa.SpringDataJpaDAO;
import org.springframework.stereotype.Component;

@Component
interface OwnerDAO extends SpringDataJpaDAO<OwnerEntity> {}
