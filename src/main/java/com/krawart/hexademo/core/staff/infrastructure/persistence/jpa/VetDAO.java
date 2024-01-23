package com.krawart.hexademo.core.staff.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.staff.domain.Vet;
import com.krawart.hexademo.shared.infrastructure.persistence.HexaDemoJpaRepository;
import org.springframework.stereotype.Component;

@Component
interface VetDAO extends HexaDemoJpaRepository<Vet> {}
