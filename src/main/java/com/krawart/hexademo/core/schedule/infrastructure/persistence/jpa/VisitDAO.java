package com.krawart.hexademo.core.schedule.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.schedule.domain.Visit;
import com.krawart.hexademo.shared.infrastructure.persistence.HexaDemoJpaRepository;
import org.springframework.stereotype.Component;

@Component
interface VisitDAO extends HexaDemoJpaRepository<Visit> {
}
