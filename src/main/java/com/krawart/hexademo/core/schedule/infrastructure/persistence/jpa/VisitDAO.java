package com.krawart.hexademo.core.schedule.infrastructure.persistence.jpa;

import com.krawart.hexademo.shared.infrastructure.persistence.jpa.SpringDataJpaDAO;
import org.springframework.stereotype.Component;

@Component
interface VisitDAO extends SpringDataJpaDAO<VisitEntity> {}
