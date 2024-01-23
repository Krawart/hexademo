package com.krawart.hexademo.core.patient.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.patient.domain.Owner;
import com.krawart.hexademo.shared.infrastructure.persistence.HexaDemoJpaRepository;
import org.springframework.stereotype.Component;

@Component
interface OwnerDAO extends HexaDemoJpaRepository<Owner> {
}
