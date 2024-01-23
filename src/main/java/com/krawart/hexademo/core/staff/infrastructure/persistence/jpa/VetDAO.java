package com.krawart.hexademo.core.staff.infrastructure.persistence.jpa;

import com.krawart.hexademo.shared.infrastructure.persistence.jpa.SpringDataJpaDAO;
import org.springframework.stereotype.Component;

@Component
interface VetDAO extends SpringDataJpaDAO<VetEntity> {}
